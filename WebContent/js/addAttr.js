$(document)
		.ready(
				function() {
					var change = new Change();
					var goodsid =judge();

					$(document).ready(function(){
						
						change.goCheck();
					});
					
					function Change() {
					}
					
					function judge(){
						/*
						 * 根据地址后缀，判断显示，并获取物品id
						 * 
						 */
							var url = window.location.search;
							var urlsb = url.substring(1);
							var urlcutF = urlsb.split("&");
							var urlcutS_f = urlcutF[0].split("=");
							var urlcutS_s = urlcutF[1].split("=");
							
							if (urlcutS_f != null && urlcutS_f[0] == "div"
								&& urlcutS_f[1] == "attr") {
								$(".allAttr").css("display", "none");
								$(".imageMana").css("display", "none");
							} else if (urlcutS_f != null && urlcutS_f[0] == "div"
								&& urlcutS_f[1] == "allAttr") {
								$(".attr").css("display", "none");
								$(".imageMana").css("display", "none");
							}else if (urlcutS_f != null && urlcutS_f[0] == "div"
								&& urlcutS_f[1] == "imageMana") {
								$(".attr").css("display", "none");
								$(".allAttr").css("display", "none");
							}
							
							if (urlcutS_s != null && urlcutS_s[0] == "id"
								&& urlcutS_s[1] != null) {
								return urlcutS_s[1];
							} else {
								return 0;
							}
							
						};
					

					$("#sub").click(function() {
						change.ajaxSub();
					});
					$("#allsub").click(function() {
						change.returnData();
					});
					/*
					 * addAttr
					 */
					Change.prototype.ajaxSub=function (){
						var att = {
							id : goodsid,
							brand : $("#branda").val(),
							size : $("#size").val(),
							color : $("#color").val(),
							imageurl : $("#imageurl").val(),
						};
						$
								.ajax({
									type : "post",
									url : "/market/goods/addgattr",
									data : JSON.stringify(att),
									contentType : "application/json;charset:utf-8",
									success : function(data) {
										if (data == 1) {
											$(location)
													.attr("href",
															"http://localhost:8080/market/jsp/manager.jsp");
										}
									},
									error : function() {
										alert("not ok");
									}
								});
					};

					/*
					 * allAttr
					 */
					
					
					Change.prototype.goCheck=function () {
						var data = {
							"id" : goodsid
						};
						$.ajax({
							type : "post",
							url : "/market/goods/getbyid",
							data : JSON.stringify(data),
							contentType : "application/json;charset=utf-8",
							dataType : "json",
							success : function(data) {
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
							error : function() {

							}
						});
					};

					Change.prototype.returnData = function() {
						var dataC = {
							"id" : $(".id").val(),
							"store" : $(".store").val(),
							"brand" : "_" + $(".brand").val(),
							"name" : $(".name").val(),
							"imageurl" : $(".imageurl").val(),
							"price" : $(".price").val(),
							"color" : $(".color").val(),
							"size" : $(".size").val(),
							"number" : $(".number").val(),
							"description" : $(".description").val()
						};
						$
								.ajax({
									type : "post",
									url : "/market/goods/addgattr",
									data : JSON.stringify(dataC),
									contentType : "application/json;charset=utf-8",
									dataType : "json",
									success : function(data) {
										$(location)
												.attr("href",
														"http://localhost:8080/market/jsp/manager.jsp");
									},
									error : function() {
									}
								});
					};

					$(".see").click(function() {
						change.imageview();
					});

					
					Change.prototype.imageview = function() {
						$(".image").trigger("click");
						$(".image").change(function(){
							$("#newfile").val($(this).val());
							$("img").attr("src",URL.createObjectURL($(this)[0].files[0]));
							
							
							$("#hid").val(goodsid);
						});	
					};
					
					
					
					
					$("#docFile").change(function(){
						/*alert($("#docFile").val());
						var file=$("#docFile")[0].files;
						alert(file[0].name);
						alert(file[0].size);*/
					});

				});