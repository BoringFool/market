$(document).ready(function(){
	$("td").attr({"valign":"top","align":"left","height":"60px","background-color":"black"});
	for(var i=0;i<$("tr").length;i++){
		if(i%2!=0){
			$("tr").eq(i).css("background-color", "#F6F6F6");
		};
	};
	/*去除重合的border边*/
	$(".pagechange ul li").css("margin-right","-1px");
	/*点击改变字体color和weight*/
	$(".pagechange ul li a").click(function(){
		$(".pagechange ul li a").removeClass("bold");
		$(this).addClass("bold");
	});
	/*点击进行分页查询,都在同一个函数里面进行，可以方便统计当前页面位置*/
	$(".pagechange ul li").eq(0).click(function(){
		
	});
	$(".pagechange ul li").eq(1).click(function(){
		
	});
	$(".pagechange ul li").eq(7).click(function(){
		
	});
	$(".pagechange ul li").eq(8).click(function(){
		
	});
});