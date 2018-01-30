<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.a:hover{
		border: 1px solid red !important;
	}
</style>
<script type="text/javascript">
	(这个要用js，父元素触发，作用在img上)(filter:alpha(opacity=80);  /*支持 IE 浏览器*/
	-moz-opacity:0.80; /*支持 FireFox 浏览器*/
	opacity:0.80;  /*支持 Chrome, Opera, Safari 等浏览器*/)
</script>
</head>
<body>
	<div class="a" style="width: 235px;height: 300px;padding:1px;cursor:pointer;border: 1px solid transparent;">
		<img alt="" src="../image/goods_pic.jpg" style="width: 185px;height: 185px;margin: 20px 25px 0px 25px;">
		<div style="width: 235px;">
			<p style="width: 135px;height: 40px;margin: 8px auto;font-size: 14px;line-height: 20px;">雀巢莜麦黑米黑芝麻3合1牛奶燕麦片即食</p>
			<span style="font-size: 18px;line-height: 18px;margin: 10px auto;display: block;text-align: center;">（价格）</span>
		</div>
	</div>
</body>
</html>