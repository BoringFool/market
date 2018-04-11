$(document).ready(function(){
	
	$("td").attr({"valign":"top","align":"left","height":"60px","background-color":"black"});
	
	for(var i=0;i<$("tr").length;i++){
		if(i%2!=0){
			$("tr").eq(i).css("background-color", "#EAEAEA");
		};
	};
});