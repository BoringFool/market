$(document).ready(function(){

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
});