
/* Event handlers */
$(window).load(function(){
	// load index.html
	console.log('Loaded test1/main.html');
});

$(function() {
	$('#popup').click(function() {
		// click popup button
		alert('Pushed popup button.');
	});	
});

$(function() {
	$('#access-token').click(function() {
		var access_token = get_access_token();
		if (access_token == null) {
			save_access_token('12345');
			access_token = get_access_token();
		}
		alert(access_token);
	});	
});


$(function() {
	$('#user-bean').click(function() {
		var users = get_my_friends();
		var g1 = new Group('group01');
		for (var i in users) {
			g1.add_user(users[i]);
		}
		alert(g1.users.length + ' ' + g1.users[1].name + ' ' + g1.users[1].where);
	});	
});

$(function() {
	$('#round-bean').click(function() {
		var users = get_my_friends();
		// members to play together.
		var rg1 = new RoundGroup();
		rg1.add_round_member(new RoundMember(users[0]));
		rg1.add_round_member(new RoundMember(users[1]));
		rg1.add_round_member(new RoundMember(users[2]));
		rg1.add_round_member(new RoundMember(users[3]));
		console.log(rg1.round_members[0].user.name);
		
		// course info
		var course = get_courses()[10];
		console.log(course.name + ', ' + course.halfs[0].name + ' course, ' + course.halfs[0].holes[5].white_yard + 'yard');
	
		// round info
		var round = new Round(course, new Date(), Weather.fine, Wind.strong, course.halfs[0].name, course.halfs[1].name);
		round.add_round_group(rg1);
		console.log(round.round_groups[0].round_members[1].user.name);
		
		
		
		// update score
		var member1 = round.round_groups[0].round_members[0];
		member1.set_score(
				1 /*hole*/,
				new Score(
						4 /*score*/, 
						1 /*putter*/,
						null /*club*/, 
						null /*fairway*/,
						null /*beach*/,
						null /*penalty*/
				)
		);
		var member2 = round.round_groups[0].round_members[1];
		member2.set_score(
				1 /*hole*/,
				new Score(
						6 /*score*/, 
						2 /*putter*/,
						null /*club*/, 
						null /*fairway*/,
						null /*beach*/,
						null /*penalty*/
				)
		);
		
		alert('user:' + round.round_groups[0].round_members[0].user.name + ' score:' + round.round_groups[0].round_members[0].scores[1].score);
	});	
});

