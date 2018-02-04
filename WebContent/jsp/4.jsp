<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-min.js"></script>
<script src="4.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

ul {
	list-style: none;
}

a {
	text-decoration: none;
	cursor: pointer;
}

.nav_con {
	background-color: #696969;
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
	font-weight: 700;
	font-family: 'Microsoft YaHei', SimSun, sans-serif;
}

.nav_con li:hover {
	background-color: #fff;
	color: red;
}
.nav_ul a{
	height: 22px;
    line-height: 22px;
    font-size: 14px;
    color: #666;
    float: left;
    margin-left: 13px;
    display: block;
}
</style>
</head>
<body>
<div style="height: 500px;overflow: hidden;position: relative;background-color: #E2244C;">
<div style="margin: 0 auto;width: 67%;">
	<div style="width: 200px; height: 500px; float: left;">
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

	<div class="aaa" style="width: 852px; height: 500px; float: left; overflow: hidden;display: none;z-index: 10;">
		<div style="width: 583px; height: 462px; margin: 19px 30px;overflow: hidden;
    				background-color: #fff; float: left;">
			<ul>
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品1
					</div>
					<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
					</div>
				</li>
				
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品
						<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					</div>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
						<a>饼干</a>
						<a>饼干</a>
					</div>
				</li>
				
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品
						<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					</div>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
					</div>
				</li>
				
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品
						<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					</div>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
						<a>饼干</a>
						<a>饼干</a>
					</div>
				</li>
			</ul>
		</div>
		
		<div style="width: 207px; height: 500px; float: left;">
			<ul>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;
					">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;
					">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
			</ul>
		</div>
	</div>
	
	<div class="aaa" style="width: 852px; height: 500px; float: left; overflow: hidden;display: none;">
		<div style="width: 583px; height: 462px; margin: 19px 30px;overflow: hidden;
    				background-color: #fff; float: left;">
			<ul>
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品2
					</div>
					<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
					</div>
				</li>
				
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品
						<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					</div>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
						<a>饼干</a>
						<a>饼干</a>
					</div>
				</li>
				
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品
						<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					</div>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
					</div>
				</li>
				
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品
						<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					</div>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
						<a>饼干</a>
						<a>饼干</a>
					</div>
				</li>
			</ul>
		</div>
		
		<div style="width: 207px; height: 500px; float: left;">
			<ul>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;
					">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;
					">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
			</ul>
		</div>
	</div>
	
	<div class="aaa" style="width: 852px; height: 500px; float: left; overflow: hidden;display: none;">
		<div style="width: 583px; height: 462px; margin: 19px 30px;overflow: hidden;
    				background-color: #fff; float: left;">
			<ul>
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品3
					</div>
					<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
					</div>
				</li>
				
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品
						<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					</div>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
						<a>饼干</a>
						<a>饼干</a>
					</div>
				</li>
				
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品
						<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					</div>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
					</div>
				</li>
				
				<li>
					<div style="width: 60px; color: #333; margin-right: 30px; position: relative;
    							font-size: 14px; font-weight: 700; line-height: 22px; height: 22px;
    							float: left;">
						进口食品
						<i style="font-family: fpIconFont!important;display: block;float: left;"></i>
					</div>
					<div class="nav_ul" style="width: 493px; float: left;border-bottom: 1px dashed;    
								border-bottom-color: #eee; border-bottom-color: rgba(0,0,0,.1);
								margin-bottom: 10.5px;padding-bottom: 10.5px;
								">
						<a>进口</a>
						<a>进口零食</a>
						<a>进口巧克力</a>
						<a>进口橄榄油</a>
						<a>进口葡萄酒</a>
						<a>进口洋酒</a>
						<a>饼干</a>
						<a>饼干</a>
						<a>饼干</a>
					</div>
				</li>
			</ul>
		</div>
		
		<div style="width: 207px; height: 500px; float: left;">
			<ul>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;
					">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;
					">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
				<li style="float: left; width: 73px; margin-right: 1px; margin-bottom: 1px; 
					height: 37px; padding: 5px 10px; overflow: hidden; background-color: #fff;">
					<a href="#">
					<img src="../image/nav_ul_brand_pic.jpg" alt="" 
						 style=" width: 73px; display: block; margin: 0 auto;border: none">
					</a>
				</li>
			</ul>
		</div>
	</div>
</div>

<div style="width: 1230px;margin: 0 auto;">
	<div class="turn" style="position: absolute;z-index: 1;margin: 0 auto;"><img alt="" src="../image/head_ad_1.jpg" /></div>
	<div class="turn" style="position: absolute;z-index: 0;"><img alt="" src="../image/head_ad_02.jpg" /></div>
	<div class="turn" style="position: absolute;z-index: 0;"><img alt="" src="../image/head_ad_1.jpg" /></div>
	<div class="turn" style="position: absolute;z-index: 0;"><img alt="" src="../image/head_ad_1.jpg" /></div>
</div>
</div>
</body>
</html>