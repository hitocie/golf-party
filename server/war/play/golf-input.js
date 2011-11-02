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
	var v = parse_query(location.search);
	var jo = JSON.parse(decodeURI(v['j']));
	golf_info = jo;
	get_me(function(user) {
		me = user; // set user to global variable.
		console.log(me.id);
	});

	var golf_name_l = $('#golf-name-l')
	golf_name_l.text(golf_info.name);
	console.log(golf_info.name);
});

/* Event handler */
$(function() {
	$("#user-add-button").click(function() {

	});
});

/* Event handler */
$(function() {
	$("#play").click(function() {
		opnClz();
	});
});

function opnClz(){
	

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
	round = create_round(round);
	alert('登録');
};