/**
 * 
 */
function init(){
	window.history.forward(1);
	$("#topMenuBar").load("top-menu.html"); 
	var currentScreen = sessionStorage.currentScreen;
	if(currentScreen == null)
		currentScreen = "about-you.html";
	$("#applicationForm").load(currentScreen, function(){
		$(this).setPageEventHandlers();
	}); 
}

$.fn.setPageEventHandlers = function()
{
	$('body').on('click', 'a.disabled', function(event) {
	    event.preventDefault();
	});

	 $( "i.toggle" ).click(function(event) {
		 $(this).parent().nextAll("div").first().slideToggle( "slow" );
		 //$(this).parent().next("form").slideToggle( "slow" );
		 $(this).toggleClass("fa-chevron-down");
	 });
};


