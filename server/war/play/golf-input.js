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
			console.log(me.id);
		});

		var golf_name = $('#golf-name');
		golf_name.text(golf_info.name);
		console.log(golf_info.name);
	} else if (prev_page == 'friend-list') {

	}
});

/* Event handler */
$(function() {
	$("#user-add-button").click(function() {

	});
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
	console.log(round.course);
//	round = create_round(round);
//	var start-hole = 0;
//	for (i=0; i<=golf_info.halfs.length; i++){
//		if(golf_info.halfs[i].name == round.first_half){
//			start-hole = golf_info.halfs[i].halfs[0].no;
//		}
//	}
//
//	location.href="golf-round.html?p=' + start-hole + '&j=' + round + '";
	var str = encodeURI(JSON.stringify(round));
	location.href="golf-round.html?j=' + str + '";
};