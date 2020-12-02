$(function(){
	$(".menuvalue").click(function(){
		var subject = $(this).children(".subject_text").text();
		var price = $(this).children(".price_text").text();
		
		$("#subject").val(subject);
		$("#price").val(price);
	});
	
});

