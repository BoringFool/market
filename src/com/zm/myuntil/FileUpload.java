package com.zm.myuntil;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUpload {

	public static String picUpdate(String a,String b,HttpServletRequest req){
		// 获取支持文件上传的Request对象 MultipartHttpServletRequest
				MultipartHttpServletRequest mtpreq = (MultipartHttpServletRequest) req;
				// 通过 mtpreq 获取文件域中的文件，文件名是file元素的id
				
				MultipartFile file = mtpreq.getFile(a);
				// 通过MultipartFile 对象获取文件的原文件名
				String fileName = file.getOriginalFilename();
				// 生成一个uuid 的文件名
				UUID randomUUID = UUID.randomUUID();
				// 获取文件的后缀名
				int i = fileName.lastIndexOf(".");
				String uuidName = randomUUID.toString() + fileName.substring(i);
				// 获取服务器的路径地址（被上传文件的保存地址）
				// C:\Users\Administrator\Documents\GitHub\market\WebContent\image
				
				String realPath = req.getSession().getServletContext().getRealPath(b);
				// 将路径转化为文件夹 并 判断文件夹是否存在
				File dir = new File(realPath);
				if (!dir.exists()) {
					dir.mkdir();
				}
				// 获取一个文件的保存路径
				String path = realPath + "\\" + uuidName;

				// 为文件这服务器中开辟一给新的空间,*没有数据
				// File newFile = new File(path);

				try {
					file.transferTo(new File(path));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.err.println("-----服务器的路径地址为：:" + realPath);
				System.err.println("-----图片名称为：:" + fileName);
				System.err.println("-----图片新名称为：:" + uuidName);
				System.err.println("-----图片新路径为：:" + path);
				return uuidName;
	}
}
