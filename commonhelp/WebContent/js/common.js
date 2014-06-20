/**
 * 
 */
function init(){
	window.history.forward(1);
	$("#topMenuBar").load("top-menu.html"); 
	var currentScreen = sessionStorage.currentScreen;
	if(currentScreen == null)
		currentScreen = "primary-applicant-basic.html";
	loadPage(currentScreen);
}

function loadPage(pageUrl){
	sessionStorage.currentScreen = pageUrl;
	$("#applicationFormDiv").load(pageUrl, function(){
		$(this).setPageEventHandlers();
	});
	$('html, body').animate({ scrollTop: 0 }, 'slow');
}

$.fn.resetLeftNavLinks = function(activeLink){
	var visitedLinksArray = [];
	if(sessionStorage.visitedLinks == null){
		visitedLinksArray = [activeLink];
	} else{
		visitedLinksArray = new Array(sessionStorage.visitedLinks);
		visitedLinksArray.push(activeLink);
	}
	
	sessionStorage.visitedLinks = visitedLinksArray;
	
	$(".leftNavLink").removeClass( "visited active" ).addClass( "disabled" );
	
	for (var i = 0; i < visitedLinksArray.length; i++) {
		$(visitedLinksArray[i]).removeClass( "disabled active" ).addClass( "visited" );
	}
	
	$(activeLink).removeClass( "disabled visited" ).addClass( "active" );
};

$.fn.setPageEventHandlers = function(){
	$('body').on('click', 'a.disabled', function(event) {
	    event.preventDefault();
	});

	 $( "i.toggle" ).click(function(event) {
		 console.debug("toggle clicked");
		 $(this).parent().nextAll("div").first().slideToggle( "slow" );
		 //$(this).parent().next("form").slideToggle( "slow" );
		 $(this).toggleClass("fa-chevron-down");
	 });
	 
	 $( "#backBtn" ).click(function( event ) {
		 	var previousPage = $(this).val();
			loadPage(previousPage);
			return false;
		});
	 
	 $( "#applicationForm" ).submit(function( event ) {
		 	var nextPage = $('#nextPage').val();
		 	var jsondata = JSON.stringify(form2js(this, '.', true));
		 	//console.debug("json data: "+jsondata);
			$.ajax({
		        url     : $(this).attr('action'),
		        type    : $(this).attr('method'),
		        contentType : "application/json; charset=utf-8",
		        dataType: 'json',
		        //data    : JSON.stringify($(this).serializeObject()),
		        data : JSON.stringify(form2js(this, '.', true)),
		        success : function( data ) {
		        	if(data.applicationId != null)
		        		sessionStorage.applicationId = data.applicationId;
		        	loadPage(nextPage);
		        },
		        error   : function( xhr, err, thrownError ) {
		            alert('Error in submission '+err+xhr+thrownError);   
		        	console.error("Error in Submission: "+thrownError);
		        	//loadPage(nextPage);
		        }
		    }); 
			return false;
		});
	 
	 $( ".datepicker" ).datepicker({ 
       	changeMonth: true,
         changeYear: true,
         yearRange: "-120:-0",
         dateFormat: "mm/dd/yy"
     });
};



$.fn.serializeObject = function(){
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
} else {
    o[this.name] = this.value || '';
        }
    });
    return o;
};

$.fn.renderHtmlFromJson = function(node, data){
		$.each(data, function(index) {
		if(typeof data[index] === 'object')
			$(this).renderHtmlFromJson(index,data[index]);
		else{
			var domId = (node == null ? "#"+index : "#"+node+"."+index);
			domId  = domId.replace(".", "\\.");
			//console.debug(domId +"="+data[index]);
			if(typeof data[index] === 'boolean')
				$(domId).html(data[index] ? 'Yes' : 'No');
			else
				$(domId).html(data[index]);
		}
    });
};


