var round_info;
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


$('#golf-round').live('pageshow', function(event, ui) {
	alert('ロジック');
	var prev_page = ui.prevPage[0].id;
	if (prev_page == 'golf-input') {
		var v = parse_query(location.search);
		var jo = JSON.parse(decodeURI(v['j']));
		round_info = jo;

		var golf_name = $('#golf-name');
		golf_name.text(round_info.course);
		console.log(golf_info.course);
		var menber_list = $('#menber-list');
		for (var i = 0 in golf_info.groups) {
			var menber = golf_info.groups[i];
			menber_list.append('<li><a href="#">' + menber.id + '</a></li>');
		}
	} else if (prev_page == 'golf-round') {

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

	get_my_rounds(function(rounds) {
		for (var i in rounds) {
			var r = rounds[i];
			// round.id, group's index, member's index, hole(0-17)
			var s1 = {id: r.id, group: 0, member: 0, hole: 1, score: 5, putter: 2};
			var s2 = {id: r.id, group: 0, member: 0, hole: 2, score: 7, putter: 1};
			var s3 = {id: r.id, group: 0, member: 0, hole: 3, score: 9, putter: 3};
			update_scores(s1, s2, s3);
		}
		console.log(round.course);
		location.href="golf-round.html?p=' + me.name + '&j=' + round + '";
	});

//	round = create_round(round);

};