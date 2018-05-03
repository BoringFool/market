$(document).ready(
		function() {
			
			
			
			/* limit_query()用 */
			tongji = 1;
			/* table样式 */
			css_add();
			/* 页面首次自动调用查询后展示 */
			ajax_q(tongji);
			
			
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
			$(".pagechange .page li").css("margin-right", "-1px");

			/* 点击进行分页查询,都在同一个函数里面进行，可以方便统计当前页面位置 */
			function limit_query(th,max_num) {
				/*
				 * 点击改变字体color和weight
				 * （“首页...”通过callback_limitq()来再次调用limit_query()来改变）
				 */
				$(".pagechange .page li a").removeClass("bold");
				th.find("a").addClass("bold");

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
				var qumo = (tongji % 5) -1;
				$(".pagechange .page li a").eq(qumo).trigger("click");
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
			
			
			/*还需要前后移li位置，下页会隔一个的问题，上一页尾页不触发问题*/
			li_change(6);
			function li_change(pagenum){
				var a="test";
				if(pagenum<=5){
					for(var i=1;i<=pagenum;i++){
						$(".pagechange .page li").eq(i).after("<li><a href=\"#\">"+i+"</a></li>");
					}
					$(".pagechange .page li a").eq(0).addClass("bold");
					/* 去除重合的border边 */
					$(".pagechange .page li").css("margin-right", "-1px");
					/*ul的宽度调整*/
					var wd=350+(pagenum*17);
					$(".pagechange .page").css("width", wd+"px");
				}else if(pagenum>5){
					var a=pagenum-5;
					for(var i=1+a;i<=pagenum;i++){
						$(".pagechange .page li").eq(i-a).after("<li><a href=\"#\">"+i+"</a></li>");
					}
					/* 去除重合的border边 */
					$(".pagechange .page li").css("margin-right", "-1px");
					$(".pagechange .page").css("width", "463px");
				}
				
				$(".pagechange .page li").on("click",function(){
					var th=$(this);
					limit_query(th,pagenum);
				});
			}
			
			$(".aaa").click(function(){
				
			});
			
			
		});