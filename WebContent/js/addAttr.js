$(document).ready(function() {
	$("#submit").click(function() {
		ajaxSub();
	});

	function ajaxSub() {
		var att = {
			id : 1,
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
});