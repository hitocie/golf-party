
/* Event handlers */
$(window).load(function(){
	// load index.html
	console.log('Loaded api-test-v1/index.html');
});

$(function() {
	$('#popup').click(function() {
		// click popup button
		alert('Pushed popup button!!!');
	});	
});

$(function() {
	/*
	$('#login').click(function() {
		login_local('200000', 'Yohsuke Sugahara', function(user) {
			console.log('Logged in id=' + user.id + ' name=' + user.name);
		});
	});
	$('#login').click(function() {
		login_local('300000', 'Yuki Arai', function(user) {
			console.log('Logged in id=' + user.id + ' name=' + user.name);
		});
	});
	$('#login').click(function() {
		login_local('400000', 'Nao Okamoto', function(user) {
			console.log('Logged in id=' + user.id + ' name=' + user.name);
		});
	});*/
	$('#login').click(function() {
		login_local('100000', 'Hitoshi Okada', function(user) {
			alert('Logged in id=' + user.id + ' name=' + user.name);
		});
	});
});

$(function() {
	$('#me').click(function() {
		get_me(function(user) {
			console.log('id=' + user.id + ' name=' + user.name);
		});
	});	
});

$(function() {
	$('#course').click(function() {
		var course = {
				name: 'ABC country club',
				address: 'Tokyo, Japan',
				half: [{
					name: 'OUT',
					holes: [
					        {no: 1, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 2, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 3, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 4, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 5, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 6, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 7, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 8, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 9, par: 3, back: 400, white: 350, red: 250, handicap: 1}
					        ]
				},
				{
					name: 'IN',
					holes: [
					        {no: 10, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 11, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 12, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 13, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 14, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 15, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 16, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 17, par: 3, back: 400, white: 350, red: 250, handicap: 1},
					        {no: 18, par: 3, back: 400, white: 350, red: 250, handicap: 1}
					        ]
				}]
		};
		create_course(course, function(course) {
			console.log('name=' + course.name + ' address=' + course.address);
		});
	});	
});


$(function() {
	$('#round').click(function() {
		var round = {
				course: 'ABC country club',
				date: '2011-10-10 09:00:00',
				first_half: 'OUT',
				last_half: 'IN',
				// wind, weather
				groups: [
				         [{id: '100000', scores: null}, {id: '200000', scores: null}],
				         [{id: '300000', scores: null}, {id: '400000', scores: null}]
				         ]
		};
		round = create_round(round);
		alert(round);

	});	
});


