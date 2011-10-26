
$('#group-edit').live('pageshow', function(event, ui) {
	var v = parse_query(location.search);

	var prev_page = ui.prevPage[0].id;
	if (prev_page == 'group-list') {
		console.log('Choice row=' + v.row);
		var lv = $('#members');
		//lv.listview();
		lv.empty(); // removed
		for (var i = 0; i < 10; i++)
			lv.append('<li>めんばー' + i + '</li>');
		lv.listview('refresh');

	} else if (prev_page == 'friend-list') {
		console.log(v.id + ' ' + v.name);
		// TODO: Add friend to Group.
	}
});

$('#group-edit').live('pagehide', function(event, ui) {
	$('#group-edit').die('pageshow');
});
