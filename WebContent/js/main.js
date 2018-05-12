$(document).ready(function(){

	/*商品展示*/
	show_goods();
	
	
	
	
	var n=0;
	
	$(".nav_con li").each(function(i){
		$(this).hover(function(){
			$(".aaa").eq(i).css("display","block");
		},function(){
			$(".aaa").eq(i).css("display","none");
		});
	});
	
	$(".aaa").hover(function(){
		$(this).css("display","block");
	},function(){
		$(this).css("display","none");
	});
	
	
	/*滚动首页ad*/
	function turn(i){
		if(i==0){
			$(".turn").eq(3).animate({"z-index":"0","opacity":"0"},1000);
			$(".turn").eq(0).animate({"z-index":"1","opacity":"1"},1000);
		}else{
			$(".turn").eq(i-1).animate({"z-index":"0","opacity":"0"},1000);
			$(".turn").eq(i).animate({"z-index":"1","opacity":"1"},1000);
		} 
		n++;
		if(n==4){
			n=0;
		}	
	}
	
	var intv=setInterval(function(){
		turn(n);
		},3000);
	/*鼠标hover清除轮播效果，离开回复*/
	$(".turn").hover(function(){
		clearInterval(intv);
	},function(){
		intv=setInterval(function(){
			turn(n);
			},3000);
	});
	
	/*hover透明度调整*/
	$(".imga,.goods_box").hover(function(){
		$(this).addClass("ttt");
	},function(){
		$(this).removeClass("ttt");
	});
	
	/*
	 * 消除（更多）应该是在从数据库读取文件后进行判断后设置
	 * */
	/*function chan(){
		var a=parseInt($(".branwall").eq("0").css("width"));
		if(a==242){
			$(this).find(".more").html(null);
		}else{
			
		}
	}
	$().click(function(){chan();});*/
	
	
	/*商标墙的鼠标hover显示*/
	$(".a_hid").hover(function(){
		$(this).find(".show_hidden").stop(true,true).fadeIn(100);
	},function(){
		$(this).find(".show_hidden").stop(true,true).fadeOut(100);
	});
	
	$(".a_hid").each(function(i,d){
		$(this).click(function(){
			$(window).attr("location","#");
		});
	});
	
	
	/*商品展示*/
	function show_goods(){
		$.ajax({
			type:"post",
			url:"",
			data:"",
			contentType:"application/json;charset=utf-8",
			dataType:"json",
			success:function(data){
				$.each(data,function(i,good){
					md(good);
				});
			},
			error:function(){
				alert("查询失败！");
			}
			
		});
		
		function md(data){
			var model="<div class=\"goods_box\">"
				+"<img alt="" src=\""+data.url+"\">"
				+"<div class=\"content_box\">"
				+"<p>"+data.description+"</p>"
				+"<span>"+data.price+"</span>"
				+"</div>"
				+"</div>";
			
			$(".goods").append(model);
		};
		
	};
	
	
	
	
	
});