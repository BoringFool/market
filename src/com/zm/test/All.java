package com.zm.test;


import java.io.File;

import org.junit.Test;

public class All {

	@Controller
	@RequestMapping("pic")
	public class FileUploadUtil{
		
		private static final Logger LOGGER = Logger.getLogger(FileUploadUtil.class);
		   @Value(value = "${IMAGE_BASE_URL}")
			private String IMAGE_BASE_URL;
			private String REPOSITORY_PATH;
			private static final ObjectMapper mapper = new ObjectMapper();
	 
			@Autowired
			private ExportService exportService;
			// 允许上传的格式
			private static final String[] IMAGE_TYPE = new String[] { ".bmp", ".jpg", ".jpeg", ".gif", ".png" };
	 
			@RequestMapping(value = "/upload", method = RequestMethod.POST)
			@ResponseBody
			public String upload(@RequestParam("uploadFile") MultipartFile[] uploadFile , HttpServletRequest request,HttpServletResponse response) throws Exception {
				REPOSITORY_PATH = request.getSession().getServletContext().getRealPath("upload");
				MultipartFile multipartFile = null;
				boolean isLegal = false;
				List<PicUploadResult> fileUploadResult = new ArrayList<>();
				PicUploadResult pic = null;
				ExportExcelConfig eec = new ExportExcelConfig();
				String urls = "";
				for (int i = 0; i < uploadFile.length; i++) {
					multipartFile = uploadFile[i];
					// 校验图片格式
					for (String type : IMAGE_TYPE) {
						if (StringUtils.endsWithIgnoreCase(multipartFile.getOriginalFilename(), type)) {
							isLegal = true;
							break;
						}
					}
	 
					// 封装Result对象，并且将文件的byte数组放置到result对象中
					pic = new PicUploadResult();
	 
					// 状态
					pic.setError(isLegal ? 0 : 1);
	 
					// 文件新路径
					String filePath = getFilePath(multipartFile.getOriginalFilename());
	 
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("Pic file upload .[{}] to [{}] ."+multipartFile.getOriginalFilename());
					}
	 
					// 生成图片的绝对引用地址
					String picUrl = StringUtils.replace(StringUtils.substringAfter(filePath,REPOSITORY_PATH), "\\", "/");
					pic.setUrl(IMAGE_BASE_URL + picUrl);
	 
					File newFile = new File(filePath);
	 
					// 写文件到磁盘
					multipartFile.transferTo(newFile);
	 
					// 校验图片是否合法
					isLegal = false;
					try {
						BufferedImage image = ImageIO.read(newFile);
						if (image != null) {
							pic.setWidth(image.getWidth() + "");
							pic.setHeight(image.getHeight() + "");
							isLegal = true;
						}
					} catch (IOException e) {
					}
	 
					// 状态
					pic.setError(isLegal ? 0 : 1);
					if(pic.getError()==0){
						urls+=pic.getUrl();
						if(i<2)
						urls+=",";
					}
					if (!isLegal) {
						// 不合法，将磁盘上的文件删除
						newFile.delete();
					}
					fileUploadResult.add(pic);
				} 
				eec.setUrl(urls);
				eec.setCreateTime(new Date());
				exportService.addConfigInfo(eec);
				response.setContentType(MediaType.TEXT_HTML_VALUE);
				return mapper.writeValueAsString(fileUploadResult);
			}
	 
			private String getFilePath(String sourceFileName) {
				String baseFolder = REPOSITORY_PATH;
				Date nowDate = new Date();
				// yyyy/MM/dd
				String fileFolder = baseFolder + File.separator + new DateTime(nowDate).toString("yyyy") + File.separator + new DateTime(nowDate).toString("MM") + File.separator
						+ new DateTime(nowDate).toString("dd");
				File file = new File(fileFolder);
				if (!file.isDirectory()) {
					// 如果目录不存在，则创建目录
					file.mkdirs();
				}
				// 生成新的文件名
				String fileName = new DateTime(nowDate).toString("yyyyMMddhhmmssSSSS") + RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(sourceFileName, ".");
				return fileFolder + File.separator + fileName;
			}
	}

}
