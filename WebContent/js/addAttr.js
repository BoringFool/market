$(document).ready(function() {
	var goodsid=judge();
	
	/*
	 * 根据地址后缀，判断显示，并获取物品id
	 * 
	 * */
	function judge(){
		var url=window.location.search;
		var urlsb=url.substring(1);
		var urlcutF=urlsb.split("&");
		var urlcutS_f=urlcutF[0].split("=");
		var urlcutS_s=urlcutF[1].split("=");
		
		if(urlcutS_f!=null&&urlcutS_f[0]=="div"&&urlcutS_f[1]=="attr"){
			$(".allAttr").css("display","none");
		}else if(urlcutS_f!=null&&urlcutS_f[0]=="div"&&urlcutS_f[1]=="allAttr"){
			$(".attr").css("display","none");
		}
		
		if(urlcutS_s!=null&&urlcutS_s[0]=="id"&&urlcutS_s[1]!=null){
			return goodsid=urlcutS_s[1];
		}else{
			return goodsid=0;
		}
		
	}
	
	
	$("#submit").click(function() {
		ajaxSub();returnData();
	});
	$(".submit").click(function() {
		returnData();
	});
	/*
	 * addAttr
	 * */
	function ajaxSub() {
		var att = {
			id : goodsid,
			brand : $("#brand").val(),
			size : $("#size").val(),
			color : $("#color").val(),
			imageurl : $("#imageurl").val(),
		};
		
		$.ajax({
			type : "post",
			url : "/market/goods/addgattr",
			data : JSON.stringify(att),
			contentType : "application/json;charset:utf-8",
			success : function(data) {
				if (data == 1) {
					$(location).attr("href","http://localhost:8080/market/jsp/manager.jsp");
				}
			},
			error : function() {
				alert("not ok");
			}
		});
	}
	
	
	/*
	 * allAttr
	 * */
	alert("in");
	goCheck();
	function goCheck(){
		var data={
				"id":goodsid
		};
		$.ajax({
			type:"post",
			url:"/market/goods/getbyid",
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			dataType:"json",
			success:function(data){
				$(".id").val(data.id);
				$(".store").val(data.store);
				$(".brand").val(data.brand);
				$(".name").val(data.name);
				$(".imageurl").val(data.imageurl);
				$(".price").val(data.price);
				$(".color").val(data.color);
				$(".size").val(data.size);
				$(".number").val(data.number);
				$(".description").val(data.description);
			},
			error:function(){
				
			}
		});
	}
	
	
	function returnData(){
		var dataC={
				"id":$(".id").val(),
				"store":$(".store").val(),
				"brand":"_"+$(".brand").val(),
				"name":$(".name").val(),
				"imageurl":$(".imageurl").val(),
				"price":$(".price").val(),
				"color":$(".color").val(),
				"size":$(".size").val(),
				"number":$(".number").val(),
				"description":$(".description").val()
		};
		$.ajax({
			type:"post",
			url:"/market/goods/addgattr",
			data:JSON.stringify(dataC),
			contentType:"application/json;charset=utf-8",
			dataType:"json",
			success:function(data){
				$(location).attr("href","http://localhost:8080/market/jsp/manager.jsp");
			},
			error:function(){}
		});
	}
});