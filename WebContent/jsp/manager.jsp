<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/manerger.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-min.js"></script>
<script src="../js/manerger.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="nav">
	
</div>

<div class="nav_tree">
	
</div>
	<div class="table-container">
		<table class="table">
			<thead>
				<tr>
					<th class="c">ID</th>
					<th class="d">图片</th>
					<th class="a">名称</th>
					<th class="a">小标题</th>
					<th class="b">价格</th>
					<th class="b">库存数量</th>
					<th class="b">图片管理</th>
					<th class="b">设置属性</th>
					<th class="c">编辑</th>
					<th class="c">删除</th>
				</tr>
			</thead>
			<!-- 一次查询5条 -->
			<tbody></tbody>
		</table>
	</div>
	<div class="pagechange">
		<ul class="page">
			<li class="change_li">首页</li>
			<li class="change_li">上一页</li>
			<li class="differ_li">
				<ul class="inner_ul">
				</ul>
			</li>
			<li class="change_li">下一页</li>
			<li class="change_li">尾页</li>
		</ul>
	</div>
	<div class="addgood">
		<div  class="ag_title">新增产品</div>
		<form action="#" method="post">
			<ul>
				<li><label for="name">产品名称</label><input id="name" type="text" ></li>
				<li><label for="description">产品小标题</label><input id="description" type="text"></li>
				<li><label for="price">价格</label><input id="price" type="text"></li>
				<li><label for="number">库存</label><input id="number" type="text"></li>
			</ul>
			<div class="submit_out"><input class="submit" type="submit" value="提交"></div>
		</form>
	</div>
	
	<div>
		<button class="aaa">hah</button>
		<button class="aaa">hah</button>
		<button class="aaa">hah</button>
		<button class="aaa">hah</button>
		<button class="aaa">hah</button>
	</div>
	
				
				<div style="width: 100px;height: 50px;border: 1px solid red;position: relative;overflow: hidden;">
				 	<ul style="width: 200px;border: 1px solid blue;">
					<li style="float: left;border: 1px solid black;">1</li>
					<li style="float: left;border: 1px solid black;">2</li>
					<li style="float: left;border: 1px solid black;">3</li>
					<li style="float: left;border: 1px solid black;">4</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
					<li style="float: left;border: 1px solid black;">5</li>
				</ul>
				</div>
</body>
</html>