<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/addAttr.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-min.js"></script>
<script src="../js/addAttr.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div id="attr" class="attr">
		<span>BRAND :<input id="brand" type="text" /></span>
		<span>COLOR :<input id="color" type="text" /></span>
		<span>SIZE :<input id="size" type="text" /></span>
		<span>IMAGEURL :<input id="imageurl" type="text" /></span>
		<span><button id="sub" class="submit">提交</button></span>
	</div>
	
	
	<div id="allAttr" class="allAttr">
		<span>ID :<input class="id" type="text" readonly="readonly" /></span>
		<span>STORE :<input class="store" type="text" readonly="readonly"/></span>
		<span>BRAND :<input class="brand" type="text" /></span>
		<span>NAME :<input class="name" type="text" /></span>
		<span>IMAGEURL :<input class="imageurl" type="text" /></span>
		<span>PRICE :<input class="price" type="text" /></span>
		<span>COLOR :<input class="color" type="text" /></span>
		<span>SIZE :<input class="size" type="text" /></span>
		<span>NUMBER :<input class="number" type="text" /></span>
		<span class="spSpan">DESCRIPTION :<textarea class="description" rows="5" cols="21"></textarea></span>
		<span><button class="submit">提交</button></span>
	</div>
</body>
</html>