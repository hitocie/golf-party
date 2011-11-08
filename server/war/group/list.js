
function show_groups(new_group) {
	var lv = $('#groups');
	lv.empty(); 
	get_my_groups(function(groups) {
		if (new_group != null)
			groups.push(new_group);
		for (var i in groups) {
			var g = groups[i];
			lv.append('<li><a href="edit.html' + to_query({id: g.id, name: g.name, users: JSON.stringify(g.users)}) + '">' + g.name + '</a><a id="delete-group" href="#" data-groupid=' + g.id + '></a></li>');
		}
		lv.listview('refresh');
	});
}

$("#group-list").live('pageshow', function(event, ui) {
	var prev_page = ui.prevPage[0].id;
	var new_group = null;
	if (prev_page == 'group-add') {
		var v = get_storage('new-group');
		if (v != null) {
			remove_storage('new-group');
			new_group = create_group({name: v, userids: []});
		}
	}
	show_groups(new_group);
});


$('#delete-group').live('click', function() {
	var groupid = $(this).jqmData('groupid');
	delete_group(groupid);
	show_groups();
});


$('#group-list').live('pagehide', function(event, ui) {
	$('#group-list').die('pageshow');
	$('#delete-group').die('click');
});


