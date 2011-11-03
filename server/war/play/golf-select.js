$('#golf-select').live('pageshow', function(event, ui) {

	get_all_courses(function(courses){
		var golf_list = $('#golf-list');
		golf_list.empty();
		for (var i in courses) {
			/*追加処理*/
			var c = courses[i];
			var str = encodeURI(JSON.stringify(courses[i]));
			golf_list.append('<li><a href="golf-input.html?p=' + c.name + '&j=' + str + '">' + c.name + '</a></li>');
		}
		golf_list.append('<li><a href="golf-input.html?p=' + '"ダミー"' + '&j=' + {} + '>ダミー</a></li>');
		golf_list.listview('refresh');
	});


});


/* Event handler */
$(function() {
	$("#popup1").click(function() {
		alert('未実装');
	});
});


