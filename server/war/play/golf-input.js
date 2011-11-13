var golf_info;
var me;

function parse_query(q) {
    var exps = q.substr(1).split('&');
    var results = [];
    for (var i = 0 in exps) {
	var p = exps[i].split('=');
	results[p[0]] = p[1];
    }
    return results;
}


$('#golf-input').live('pageshow', function(event, ui) {
	var prev_page = ui.prevPage[0].id;
	if (prev_page == 'golf-select') {
		var v = parse_query(location.search);
		var jo = JSON.parse(decodeURI(v['j']));
		golf_info = jo;
		get_me(function(user) {
			me = user; // set user to global variable.
//			console.log(me.id);
		});

		// name
		var golf_name = $('#golf-name');
		golf_name.text(golf_info.name);
//		console.log(golf_info.name);

		// member
		get_my_friends(function(friends) {
			var member = $('#member');
			member.empty();
			for (var i = 0 in friends) {
				var f = friends[i];
				member.append('<option value="' + f.id + '">' + f.name + '</option>');
			}
			member.selectmenu('refresh');
		});

		// group
		get_my_groups(function(groups) {
			var group = $('#group');
			group.empty();
//			if (new_group != null)
//				groups.push(new_group);
			for (var i in groups) {
				var g = groups[i];
				group.append('<option value="' + g.id + '">' + g.name + '</option>');
			}
			group.selectmenu('refresh');
		});

		// start

	}
});



/* Event handler */
$(function() {
	$("#play").click(function() {
		if (check()){
			entry();
		}
	});
});

function check(){
	var play_date = $('#play-date').val();
	if (play_date == ''){
		alert('日付未入力');
		return false;
	}

	return true;
}

function entry(){
	var play_date = $('#play-date').val();
	var weather = $('#weather');
	var wind = $('#wind');
	var round = {
			course: golf_info.name,
			date: '2011-10-10 09:00:00',
			first_half: 'OUT',
			last_half: 'IN',
			weather: Weather.fine,
			wind: Wind.no,
			groups: [
			         [{id: me.id, scores: null}]
			         ]
	};

	create_round(round);
	console.log(round.course);
	var start_hole = 1;
	for (var i = 0 in golf_info.halfs){
//		if(golf_info.halfs[i].name == round.first_half){
//			start_hole = golf_info.halfs[i].halfs[0].no;
//		}
	}
//	var str = encodeURI(JSON.stringify(round));
//	console.log(start_hole);
	set_storage('golf-round', round);
	set_storage('now-play', {half:'OUT', hole:start_hole});
	$.mobile.changePage(
			'golf-round.html', 'pop', false, false
	);
};