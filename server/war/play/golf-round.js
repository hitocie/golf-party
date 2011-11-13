var round_info;
var now_play;
//var me;

//function parse_query(q) {
//    var exps = q.substr(1).split('&');
//    var results = [];
//    for (var i = 0 in exps) {
//	var p = exps[i].split('=');
//	results[p[0]] = p[1];
//    }
//    return results;
//}


$('#golf-round').live('pageshow', function(event, ui) {
	alert('ロジック');
	round_info = get_storage('golf-round');
	now_play = get_storage('now-play');
	if (round_info != null) {
		remove_storage('golf-round');
	}
	if (now_play != null) {
		remove_storage('now-play');
	}
	var prev_page = ui.prevPage[0].id;
	if (prev_page == 'golf-input') {

		var golf_name = $('#golf-name');
		golf_name.text(round_info.course);

		var round_name = $('#round-name');
		round_name.text(now_play.hole);

//		var round = $('#round-name');
//		round_name.text(now_play.half);

//		var menber_list = $('#menber-list');
//		for (var i = 0 in golf_info.groups) {
//			var menber = golf_info.groups[i];
//			menber_list.append('<li><a href="#">' + menber.id + '</a></li>');
//		}
	} else if (prev_page == 'golf-round') {
		var golf_name = $('#golf-name');
		golf_name.text(round_info.course);

		var round_name = $('#round-name');
		round_name.text(now_play.hole);
//
	}
});



/* Event handler */
$(function() {
	$("#next").click(function() {
		if (check()){
			update();
		}
	});
});

function check(){

	return true;
}

function update(){

//	get_my_rounds(function(rounds) {
//		for (var i in rounds) {
//			var r = rounds[i];
//			// round.id, group's index, member's index, hole(0-17)
//			var s1 = {id: r.id, group: 0, member: 0, hole: 1, score: 5, putter: 2};
//			var s2 = {id: r.id, group: 0, member: 0, hole: 2, score: 7, putter: 1};
//			var s3 = {id: r.id, group: 0, member: 0, hole: 3, score: 9, putter: 3};
//			update_scores(s1, s2, s3);
//		}
		now_play.hole = now_play.hole + 1;
		console.log(now_play.hole);
		set_storage('golf-round', round_info);
		set_storage('now-play', {half:'OUT', hole:now_play.hole});
		$.mobile.changePage(
				'golf-round.html', 'pop', false, false
		);
//	});

//	round = create_round(round);

};