$(document)
		.ready(
				function() {

					/* limit_query()用 */
					tongji = 1;
					/* 第一次加载给第一个li通过出发点击添加css样式 */
					trig = false;
					/* 总页数 */
					count = 1;
					/* 获取总页数 */
					count_num();
					/* 页面首次加载，获取并添加页面li */
					add_li(count);
					/* 页面首次自动调用查询后展示td */
					ajax_q(tongji);

					/* 去除重合的border边 */
					$(".pagechange .page li").css("margin-right", "-1px");

					/* table中各个td的固定width以及其他css样式 */
					function css_add() {
						$("th").eq(1).attr("width", "40px");
						$("th").eq(2).attr("width", "160px");
						$("th").eq(3).attr("width", "300px");
						$("th").eq(4).attr("width", "300px");
						$("th").eq(5).attr("width", "80px");
						$("th").eq(6).attr("width", "80px");
						$("th").eq(7).attr("width", "80px");
						$("th").eq(8).attr("width", "80px");
						$("th").eq(9).attr("width", "40px");
						$("th").eq(10).attr("width", "40px");

						$("td").attr({
							"valign" : "top",
							"align" : "left",
							"height" : "50px",
							"background-color" : "black",
							"word-wrap" : "break-word",
							"word-break" : "break-all",
						});
						/* 隔一个改变td背景色 */
						for (var i = 0; i < $("tr").length; i++) {
							if (i % 2 != 0) {
								$("tr").eq(i)
										.css("background-color", "#F6F6F6");
							}
							;
						}
						;
					}
					;

					/*
					 * 点击进行分页查询,都在同一个函数里面进行，可以方便统计当前页面位置 th $(this),max_num页数最大值
					 */
					function limit_query(th, max_num) {
						/*
						 * 点击改变字体color和weight
						 * （“首页...”通过callback_limitq()来再次调用limit_query()来改变）
						 */

						if (max_num == 0) {
							max_num = 1;
						}

						if (th.parent().attr("class") == "inner_ul") {
							$(".inner_ul li").removeClass("bold");
							th.addClass("bold");
						}

						var text = th.text();

						if (text == "上一页") {
							if ((tongji - 1) <= 1) {
								tongji = 1;
							} else {
								tongji = tongji - 1;
							}
							callback_limitq();
							return;
						} else if (text == "首页") {
							tongji = 1;
							callback_limitq();
							return;
						} else if (text == "下一页") {
							/*
							 * 因为tongji=tongji+1会出错无法得出正确结果（结果为21，然后51之后一直是51），
							 * tongji=++tongji是非法的，所以用c过度
							 */
							var c = ++tongji;
							tongji = c;
							if (tongji >= max_num) {
								tongji = max_num;
							} else {
								tongji;
							}
							callback_limitq();
							return;
						} else if (text == "尾页") {
							tongji = max_num;
							callback_limitq();
							return;
						} else {
							tongji = text;
						}
						ajax_q(tongji);
					}
					;

					/* 用来解决点击“首页上一页...”这四个个li的时候“li a”的css样式改变问题 */
					function callback_limitq() {
						var qumo = tongji - 1;
						$(".inner_ul li").eq(qumo).trigger("click");
					}

					function count_num() {
						$.ajax({
							type : "post",
							url : "/market/goods/count",
							async : false, // 这里如果不设置成同步的话，count的值取不到
							dataType : "json",
							success : function(data) {
								count = Math.ceil((data.a) / 5);
							},
							error : function() {
								alert("查询失败");
							}
						});
						return count;
					}
					/* 分批查询 */
					function ajax_q(num) {
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
								/* 页数1样式改变 */
								if (trig == false) {
									$(".inner_ul li").eq(0).trigger("click");
									trig = true;
								}

							},
							error : function() {
								alert("fault");
							}
						});

					}

					/* tbody中td的模版 */
					function show(data) {
						var content = "<tr>" + "<td>" + data.id + "</td>"
								+ "<td>" + data.imgeurl + "</td>" + "<td>"
								+ data.name + "</td>" + "<td>"
								+ data.description + "</td>" + "<td>"
								+ data.price + "</td>" + "<td>" + data.number
								+ "</td>" + "<td>" + "图片管理" + "</td>" + "<td>"
								+ "设置属性" + "</td>" + "<td>" + "编辑" + "</td>"
								+ "<td>" + "删除" + "</td>" + "</tr>";
						$("tbody").append(content);
					}
					;

					/*
					 * 这一部分本来是准备点击触发，但是出了很多问题，感觉很复杂，就换成了另外一种方式来实现。
					 * 
					 * 
					 * 
					 * 
					 * 还需要前后移li位置，下页会隔一个的问题，上一页尾页不触发问题 li_change(5); function
					 * li_change(pagenum){ var a="test"; if(pagenum<=5){
					 * for(var i=1;i<=pagenum;i++){ $(".pagechange .page
					 * li").eq(i).after("<li><a href=\"#\">"+i+"</a></li>"); }
					 * $(".pagechange .page li a").eq(0).addClass("bold");
					 * 去除重合的border边 $(".pagechange .page
					 * li").css("margin-right", "-1px"); ul的宽度调整 var
					 * wd=350+(pagenum*17); $(".pagechange .page").css("width",
					 * wd+"px"); }else if(pagenum>5){ var a=pagenum-5; for(var
					 * i=1+a;i<=pagenum;i++){ $(".pagechange .page
					 * li").eq(i-a).after("<li><a href=\"#\">"+i+"</a></li>"); }
					 * 去除重合的border边 $(".pagechange .page
					 * li").css("margin-right", "-1px"); $(".pagechange
					 * .page").css("width", "463px"); }
					 * 
					 * $(".pagechange .page li").on("click",function(){ var
					 * th=$(this); limit_query(th,pagenum); }); }
					 */

					/* 用来添加底部页数li */
					function add_li(cunt) {
						if (cunt == 0) {
							cunt = 1;
						}
						if (cunt < 5) {
							var d_value = 190 - 38 * (5 - cunt);
							var d_va = 434 - 38 * (5 - cunt);
							$(".differ_li").css("width", d_value + "px");
							$(".pagechange .page").css("width", d_va + "px");
						}

						for (var i = 1; i <= cunt; i++) {
							$(".inner_ul").append("<li>" + i + "</li>");
						}
					}
					/* 第一层ul外的前后4个li绑定事件 */
					$(".change_li").click(function() {
						var th = $(this);
						limit_query(th, count);
					});
					/* ul内的ul事件绑定 */
					$(".inner_ul li").click(function() {
						var text = $(this).text();
						var th = $(this);
						panduan(text, count);
						limit_query(th, count);
					});

					/* 判断是否需要移动ul */
					function panduan(text, max) {
						if (max == 0) {
							max = 1;
						}

						if ((text - 3) > 1) {
							/* 判断是否到达最后5页 */
							if ((max - text) <= 1) {
								if ((max - text) == 1) {
									var a = text - 4;
									move_li(a);
									return;
								} else if ((max - text) == 0) {
									var a = text - 5;
									move_li(a);
									return;
								}
								{
									return;
								}
							} else {
								var a = text - 3;
								move_li(a);
							}
						} else {
							move_li(0);
						}
					}

					/* li移动渐变动画 */
					function move_li(times) {
						var t = times * -38;
						$(".inner_ul").stop(true, true).animate({
							"margin-left" : t + "px"
						}, 250);
					}

					/* 判断是否为空，空格，null，undefined */
					function ifnull(str) {
						var regu = "^[ ]+$";
						var re = new RegExp(regu);

						var bool = re.test(str);
						if (typeof str == "undefined" || str == null
								|| str == "" || bool == true) {
							return true;
						}
						return false;
					}
					/* 判断是否为数字 */
					function ifnum(num) {
						if (isNaN(num)) {
							return true;
						} else {
							return false;
						}
					}

					/* 添加商品 */
					$("#submit").click(function() {
						test();
					});
					function test() {
						var number = $("#number").val();
						var price = $("#price").val();
						var description = $("#description").val();
						var name = $("#name").val();

						if (ifnull(number) || ifnull(price) || ifnum(number)
								|| ifnum(price) || ifnull(description)
								|| ifnull(name)) {
							alert("不可为空！价格和库存必须为数字！");
							return;
						}
						var data = {
							"name" : name,
							"description" : description,
							"price" : price,
							"number" : number,
						};

						$.ajax({
							type : "post",
							url : "/market/goods/addg",
							data : JSON.stringify(data),
							contentType : "application/json;charset=utf-8",
							datatype : "json",
							success : function(data) {
								alert("添加成功，物品ID号为" + data.a);
								/* 这个方法如果放在ajax外调用，会导致ajax后台动作成功，
								 * 但是进入error方法。既数据能成功在后台保存成功，但是ajax调用失败 */
								cleanli();
							},
							error : function(XMLHttpRequest, textStatus,
									errorThrown) {
								alert(XMLHttpRequest.status);
								alert(XMLHttpRequest.readyState);
								alert(textStatus);
							},
						});

					}
					
					/*提交成功后刷新页面*/
					function cleanli() {
						/* 添加成功后清空input */
						$("#add_form li input").val("");
						/* 刷新展示到第一页 */
						history.go(0);
					}
				});