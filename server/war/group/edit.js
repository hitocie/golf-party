

$('#group-edit').live('pageshow', function(event, ui) {
	var v = parse_query(location.search);
	var name = v.name;
	
	var users = JSON.parse(v.users);
	get_my_friends(function(friends) {
		var sc = $('#select-members');
		sc.empty();
		for (var i = 0 in friends) {
			var f = friends[i];
			var flag = false;
			for (var j = 0 in users) {
				if (f.id == users[j].id) {
					flag = true;
					break;
				}
			}
			if (flag)
				sc.append('<option value="' + f.id + '" selected="true">' + f.name + '</option>');
			else
				sc.append('<option value="' + f.id + '">' + f.name + '</option>');
		}
		sc.selectmenu('refresh');

		set_storage('group', {id: v.id, name: v.name, users: users});
		$('#group-name').text(name);
	});
});


$('#group-edit').live('pagehide', function(event, ui) {
	$('#group-edit').die('pageshow');
	if (ui.nextPage[0].id == 'group-list')
		remove_storage('group');
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


$('#select-members').live('change', function() {
	var group = get_storage('group');
	group.users.splice(0, group.users.length);
	var users = $(this).val();
	if (users != null) {
		for (var i = 0 in users) {
			group.users.push({id: users[i]});
		}
	}
	set_storage('group', group);
});