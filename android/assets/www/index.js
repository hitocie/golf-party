
/* Event handlers */
$(window).load(function(){
	// load index.html
	console.log('Loaded index.html');
});

$(function() {
	$('#popup').click(function() {
		// click popup button
		alert('Pushed popup button.');
	});	
});

$(function() {
	$('#hokada').click(function() {
		/* click hokada button */		
		var access_token = get_access_token();
		if (access_token == null) {
			save_access_token('12345');
			access_token = get_access_token();
		}
		alert(access_token);
	});	
});

