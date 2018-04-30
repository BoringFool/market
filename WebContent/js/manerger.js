$(document).ready(
		function() {
			/* limit_query()用 */
			tongji = 1;
			/* table样式 */
			css_add();
			/* 页面首次自动调用查询后展示 */
			ajax_q(tongji);
			/* 点击触发查询 */
			limit_query();

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
				/*隔一个改变td背景色*/
				for (var i = 0; i < $("tr").length; i++) {
					if (i % 2 != 0) {
						$("tr").eq(i).css("background-color", "#F6F6F6");
					}
					;
				}
				;
			}
			;

			/* 去除重合的border边 */
			$(".pagechange ul li").css("margin-right", "-1px");

			/* 点击进行分页查询,都在同一个函数里面进行，可以方便统计当前页面位置 */
			function limit_query() {
				$(".pagechange ul li").click(function() {
					/*
					 * 点击改变字体color和weight
					 * （“首页...”通过callback_limitq()来再次调用limit_query()来改变）
					 */
					$(".pagechange ul li a").removeClass("bold");
					$(this).find("a").addClass("bold");

					var text = $(this).text();

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
						if (tongji >= 5) {
							tongji = 5;
						} else {
							tongji;
						}
						callback_limitq();
						return;
					} else if (text == "尾页") {
						tongji = 10;
						callback_limitq();
						return;
					} else {
						tongji = text;
					}
					ajax_q(tongji);
				});
			}
			;
			/* 用来解决点击“首页上一页...”这四个个li的时候“li a”的css样式改变问题 */
			function callback_limitq() {
				var qumo = (tongji % 5) - 1;
				$(".pagechange ul li a").eq(qumo).trigger("click");
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
					},
					error : function() {
						alert("fault");
					}
				});
			}

			/*tbody中td的模版*/			 
			function show(data) {
				var content = "<tr>" + "<td>" + data.id + "</td>" + "<td>"
						+ data.imgeurl + "</td>" + "<td>" + data.name + "</td>"
						+ "<td>" + data.description + "</td>" + "<td>"
						+ data.price + "</td>" + "<td>" + data.number + "</td>"
						+ "<td>" + "图片管理" + "</td>" + "<td>" + "设置属性" + "</td>"
						+ "<td>" + "编辑" + "</td>" + "<td>" + "删除" + "</td>"
						+ "</tr>";
				$("tbody").append(content);
			}
			;
		});