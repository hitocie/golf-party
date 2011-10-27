
$('#group-edit').live('pageshow', function(event, ui) {
	var v = parse_query(location.search);

	var lv = $('#members');
	var prev_page = ui.prevPage[0].id;
	if (prev_page == 'group-list') {
		console.log('Choice id=' + v.id + ' name=' + v.name);
		lv.empty();
		var users = JSON.parse(v.users);
		for (var i = 0 in users) {
			var u = users[i];
			lv.append('<li>' + u.name + '</li>');
		}
		lv.listview('refresh');
		set_storage('group', {id: v.id, name: v.name, users: users});

	} else if (prev_page == 'friend-list') {
		var group = get_storage('group');
		group.users.push({id: v.id, name: v.name});
		for (var i = 0 in group.users) {
			var u = group.users[i];
			lv.append('<li>' + u.name + '</li>');
		}
		lv.listview('refresh');
		set_storage('group', group);
	}
});

$('#group-edit').live('pagehide', function(event, ui) {
	$('#group-edit').die('pageshow');
	if (ui.nextPage[0].id == 'group-list') {
		remove_storage('group');
	}
});



$(function() {
	$('#save').click(function() {
		var g = get_storage('group');
		var userids = [];
		for (var i in g.users) {
			var u = g.users[i];
			userids.push(u.id);
		}
		update_group({id: g.id, name: g.name, userids: userids});
	});	
});


