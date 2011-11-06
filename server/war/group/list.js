
function show_groups() {
	var lv = $('#groups');
	lv.empty(); // removed
	get_my_groups(function(groups) {
		for (var i in groups) {
			var g = groups[i];
			//lv.append('<li><a href="edit.html' + to_query({id: g.id, name: g.name, users: JSON.stringify(g.users)}) + '">' + g.name + '</a></li>');
			lv.append('<li><a href="edit.html' + to_query({id: g.id, name: g.name, users: JSON.stringify(g.users)}) + '">' + g.name + '</a><a id="delete-group" href="#" data-groupid=' + g.id + '></a></li>');
		}
		lv.listview('refresh');
	});
}

$("#group-list").live('pageshow', function(event, ui) {
	var prev_page = ui.prevPage[0].id;
	if (prev_page == 'group-add') {
		var v = get_storage('new-group');
		if (v != null) {
			remove_storage('new-group');
			var new_group = {name: v, userids: []};
			new_group = create_group(new_group);
		}
	}
	show_groups();
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


