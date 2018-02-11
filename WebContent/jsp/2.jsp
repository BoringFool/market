<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-min.js"></script>
<script type="text/javascript">
if (typeof jQuery == 'undefined') {
	window.alert("没有jquery");
}
	$(document).ready(function(){
		
		
		$("#a_hid").hover(function(){
			$("#b").stop(true,true).fadeIn(200);
		},function(){
			$("#b").stop(true,true).fadeOut(200);
		});
	});
</script>
</head>
<body>
	<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
	<a id="a_hid" href="#" style="width: 122px;height: 108px;list-style: none;display: block;float: left;position: relative;">
		<div style="width: 122px; height: 108px;position: relative;z-index: 1;">
		<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
			<img alt="" src="../image/shop_pic.jpg" style="display: block; width: 80%; height: 50px; margin: 29px auto;border: none;"/>
		</div>
		
		<!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
		<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
		<div id="b" style="display: none;background-color: #333;background-color:rgba(0,0,0,0.8);top: 0;left: 0;z-index: 2;height: 108px;width: 122px;position: absolute;">
			<div id="hidde" style="width: 63px;margin: 35px auto;">
				<div style="margin-bottom: 10px;">
				<span style="color: #fff;font-size: 13px;line-height: 16px;text-align: center;display: block;">belublu</span>
				</div>
				<span style="margin-top:0;display: block;background-color: #FF0036;color: #fff;border: 1px solid #FF0036;border-radius: 9px;width: 63px;height: 18px;font-size: 12px;line-height: 15px;text-align: center; ">点击进入</span>
			</div>
		</div>
		</a>
</body>
</html>