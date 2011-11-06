
function create_list(users) {
	var lv = $('#members');
	lv.empty();
	for (var i = 0 in users) {
		var u = users[i];
		lv.append('<li><a href="#">' + u.name + '</a><a id="delete-user" href="#" data-userid=' + u.id + '></a></li>');
	}
	lv.listview('refresh');	
}


$('#group-edit').live('pageshow', function(event, ui) {
	var v = parse_query(location.search);
	var name = v.name;
	
	var prev_page = ui.prevPage[0].id;
	if (prev_page == 'group-list') {
		var users = JSON.parse(v.users);
		create_list(users);
		set_storage('group', {id: v.id, name: v.name, users: users});

	} else if (prev_page == 'friend-list') {
		var group = get_storage('group');
		name = group.name;
		// not back button
		if (v.id != undefined) {
			group.users.push({id: v.id, name: v.name});
		}
		create_list(group.users);
		set_storage('group', group);
	}
	$('#group-name').text(name);
});


$('#delete-user').live('click', function() {
	var userid = $(this).jqmData('userid');
	var group = get_storage('group');
	for (var i in group.users) {
		var u = group.users[i];
		if (u.id == userid) {
			group.users.splice(i, 1);
			set_storage('group', group);
			break;
		}
	}
	var lv = $('#members');
	create_list(group.users);
});


$('#group-edit').live('pagehide', function(event, ui) {
	$('#group-edit').die('pageshow');
	$('#delete-user').die('click');
	if (ui.nextPage[0].id == 'group-list') {
		remove_storage('group');
	}
});


$('#save').click(function() {
	var g = get_storage('group');
	var userids = [];
	for (var i in g.users) {
		var u = g.users[i];
		userids.push(u.id);
	}
	update_group({id: g.id, name: g.name, userids: userids});
});
