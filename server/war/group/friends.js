
$('#friend-list').live('pageshow', function(event, ui) {
	get_my_friends(function(friends) {
		var lv = $('#friends');
		lv.empty(); // removed
		for (var i = 0 in friends) {
			var f = friends[i];
			lv.append('<li><a href="edit.html' + to_query(f) + '">' + f.name + '</a></li>');
		}
		lv.listview('refresh');
	});
});


$('#friend-list').live('pagehide', function(event, ui) {
	$('#friend-list').die('pageshow');
});

