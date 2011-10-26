
$("#group-list").live('pageshow', function(event, ui) {
	var lv = $('#groups');
	lv.empty(); // removed
	for (var i = 0; i < 10; i++) {
		lv.append('<li><a href="edit.html' + to_query({row: i}) + '">グループ' + i + '</a></li>');
	}
	lv.listview('refresh');
});

$('#group-list').live('pagehide', function(event, ui) {
	$('#group-list').die('pageshow');
});

