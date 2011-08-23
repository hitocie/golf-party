
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
		var me = new Me('0001', 'Hitoshi Okada', 
				[{id:'0002', name:'Yuki Arai'}, {id:'0003', name:'Nao Okamoto'}]
		);
		alert(me.friends[1].name);
		
		var access_token = get_access_token();
		if (access_token == null) {
			save_access_token('12345');
			access_token = get_access_token();
		}
		alert(access_token);
	});	
});

