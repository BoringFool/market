<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
ul{
	list-style: none;
}
a{
	text-decoration: none;
	cursor: pointer;
}
.nav_con {
	background-color: #000;	
	filter:alpha(opacity=35);  /*支持 IE 浏览器*/
	-moz-opacity:0.35; /*支持 FireFox 浏览器*/
	opacity:0.35;  /*支持 Chrome, Opera, Safari 等浏览器*/)
	background-color: rgba(0, 0, 0, .55);
	width: 200px;
	height: 500px;
	position: relative;
	z-index: 11;
}

.nav_con li {
	height: 31.2px;
	line-height: 31.2px;
	color: #fff;
	font-size: 14px;
	font-weight:700;
	font-family: 'Microsoft YaHei',SimSun,sans-serif;
}
.nav_con li:hover{
	background-color: #fff;	
	color:red;
}
</style>
</head>
<body>
	<div style="width: 200px; height: 500px;">
		<ul class="nav_con">
			<li><i>(这里是有一个小小图标的)</i>女装</li>
			<li>男装</li>
			<li>女鞋</li>
			<li>美妆</li>
			<li>腕表</li>
			<li>手机</li>
			<li>母婴</li>
			<li>零食</li>
			<li>生鲜水果</li>
			<li>大家电</li>
			<li>家具器材</li>
			<li>汽车</li>
			<li>家纺</li>
			<li>医药</li>
			<li>厨具</li>
			<li>图音</li>
		</ul>
	</div>

</body>
</html>