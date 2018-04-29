$(document).ready(function() {
	count=1;
	css_add();
	a(count);
	b();
	
	function css_add(){
		$("th").eq(1).attr("width","40px");
		$("th").eq(2).attr("width","160px");
		$("th").eq(3).attr("width","300px");
		$("th").eq(4).attr("width","300px");
		$("th").eq(5).attr("width","80px");
		$("th").eq(6).attr("width","80px");
		$("th").eq(7).attr("width","80px");
		$("th").eq(8).attr("width","80px");
		$("th").eq(9).attr("width","40px");
		$("th").eq(10).attr("width","40px");
		
		$("td").attr({
			"valign" : "top",
			"align" : "left",
			"height" : "60px",
			"background-color" : "black",
			"word-wrap":"break-word",
			"word-break":"break-all",
		});
		for (var i = 0; i < $("tr").length; i++) {
			if (i % 2 != 0) {
				$("tr").eq(i).css("background-color", "#F6F6F6");
			}
			;
		};
	};
	
	/* 去除重合的border边 */
	$(".pagechange ul li").css("margin-right", "-1px");
	/* 点击改变字体color和weight */
	$(".pagechange ul li a").click(function() {
		$(".pagechange ul li a").removeClass("bold");
		$(this).addClass("bold");
	});
	/* 点击进行分页查询,都在同一个函数里面进行，可以方便统计当前页面位置 */
	function b(){
		$(".pagechange ul li").click(function() {
			var text=$(this).text();
			if(text=="上一页"){
				if((count-1)<=1){
					count=1;
				}else{
					count=count-1;
				}
				var aa=(count%5)-1;
				$(".pagechange ul li a").eq(aa).trigger("click");
				return;
			};
			if(text=="首页"){
				count=1;
				
			};
			
			if(text=="下一页"){
				alert(count);
				var tt=count+1;
				if(tt>=5){
					count=5;
				}else{
					count=count+1;
				}
				alert(count);
				var aa=(count%5)-1;
				$(".pagechange ul li a").eq(aa).trigger("click");
				return;
				
			};
			if(text=="尾页"){
				count=10;
			};
			count=text;
			
			a(count);
		});
	};
	
	function a(num){
		$("tbody").empty();
		var g = {
				"id" : num,
			};
		$.ajax({
			type : "post",
			url : "/market/goods/query",
			data : JSON.stringify(g),
			contentType : "application/json;charset=utf-8",
			datatype : "json",
			success : function(data) {
				$.each(data, function(i, topic) {
					show(topic);
				});
				css_add();
			},
			error : function() {
				alert("fault");
			}
		});
	}
	
	function show(data){
			var content="<tr>" +
				"<td>"+data.id+"</td>" +
				"<td>"+data.imgeurl+"</td>" +
				"<td>"+data.name+"</td>"+
				"<td>"+data.description+"</td>"+
				"<td>"+data.price+"</td>"+
				"<td>"+data.number+"</td>"+
				"<td>"+"图片管理"+"</td>"+
				"<td>"+"设置属性"+"</td>"+
				"<td>"+"编辑"+"</td>"+
				"<td>"+"删除"+"</td>"+
				"</tr>";
			$("tbody").append(content);
	};
});