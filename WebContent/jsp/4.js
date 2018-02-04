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
	
	function turn(i){
		$(".turn").eq(i).animate({"z-index":"1"});
		setTimeout(function(){$(".turn").eq(i).animate({"z-index":"0"});},i*5000); 
		
		
	}
	$.each([1,2,3,4],function(d,i){turn(d);});
	
});