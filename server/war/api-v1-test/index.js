
// global variables
var g_me;


/* Event handlers */
// Don't work when not rel="external".
/*
$(window).load(function() {
	// load index.html
	console.log('Loaded api-test-v1/index.html');
	// if I logged in facebook, set user object to global variable.
	if (is_login()) {
		get_me(function(user) {
			g_me = user;
		});
	}
});
*/

// Event handler to show page. (instead of "load()")
$(function() {
    $("div[data-role*='page']").live('pageshow', function(event, ui) {
    	if (this.id == 'page-test') {
    		// load index.html
    		console.log('Loaded api-test-v1/index.html');
    		// if I logged in facebook, set user object to global variable.
    		if (is_login()) {
    			get_me(function(user) {
    				g_me = user;
    			});
    		}
    	}
    });
});



$(function() {
	$('#login').click(function() {
		alert('Login? ' + is_login());
		if (!is_login()) {
			/*
			login_local('200000', 'Yohsuke Sugahara', function(user) {
				console.log('Logged in id=' + user.id + ' name=' + user.name);
			});
			login_local('300000', 'Yuki Arai', function(user) {
				console.log('Logged in id=' + user.id + ' name=' + user.name);
			});
			login_local('400000', 'Nao Okamoto', function(user) {
				console.log('Logged in id=' + user.id + ' name=' + user.name);
			});
			*/
			login_local('100000', 'Hitoshi Okada', function(user) {
				get_me(function(user) {
					g_me = user; // set user to global variable.
				});
				alert('Logged in id=' + user.id + ' name=' + user.name);
			});
		}
	});
});

$(function() {
	$('#me').click(function() {
		// me
		get_me(function(user) {
			dump_user(user);
			
			// friends
			get_my_friends(function(friends) {
				for (var i in friends) {
					dump_user(friends[i], '[Friend]');
				}
			});
		});
	});	
});

$(function() {
	$('#course_show').click(function() {
		// get all areas
		var areas = get_all_areas(function(areas) {
			console.log('areas=' + JSON.stringify(areas));
			
			// find courses
			find_courses(areas[0], null, function(courses) {
				for (var i in courses) {
					console.log('[Found courses] course=' + courses[i].name);
				}
			});
		});
		
		// get all courses
		var courses = get_all_courses(function(courses) {
			for (var i in courses) {
				var c = courses[i];
				dump_course(c);
			}
		}); 
	});	
});

$(function() {
	$('#course_create').click(function() {
		
		var course1 = {
				name: 'ABC country club',
				area: '愛知県',
				address: 'Tokyo, Japan',
				halfs: [{
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
		var course2 = {
				name: 'あいうえおカントリークラブ',
				area: '東京都',
				address: '東京都港区',
				halfs: [{
					name: 'ぜんはんコース',
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
					name: 'こうはんコース',
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
		var c1 = create_course(course1);
		dump_course(c1);
		var c2 = create_course(course2);
		dump_course(c2);
	});	
});

$(function() {
	$('#course_delete').click(function() {
		// get all courses
		var courses = get_all_courses(function(courses) {
			for (var i in courses) {
				// delete_course
				delete_course(courses[i]);
			}
		}); 
	});
});

$(function() {
	$('#round_create').click(function() {
		var round = {
				course: 'ABC country club',
				date: '2011-10-10 09:00:00',
				first_half: 'OUT',
				last_half: 'IN',
				weather: Weather.fine,
				wind: Wind.no,
				groups: [
				         [{id: g_me.id, scores: null}, {id: '200000', scores: null}],
				         [{id: '300000', scores: null}, {id: '400000', scores: null}]
				         ]
		};
		round = create_round(round);
		dump_round(round, '[Created Round]');
	});	
});

$(function() {
	$('#round_show').click(function() {

		// get all my rounds
		get_my_rounds(function(rounds) {
			for (var i in rounds) {
				var r = rounds[i];
				//dump_round(r);

				// get one round
				get_round(r.id, function(round) {
					dump_round(round);
				});

			}
		});
	});	
});

$(function() {
	$('#round_delete').click(function() {

		get_my_rounds(function(rounds) {
			for (var i in rounds) {
				var r = rounds[i];
				delete_round(r);
				dump_round(r, '[Deleted]');
			}
		});
	});	
});

$(function() {
	$('#update_scores').click(function() {

		get_my_rounds(function(rounds) {
			for (var i in rounds) {
				var r = rounds[i];
				// round.id, group's index, member's index, hole(0-17)
				var s1 = {id: r.id, group: 0, member: 0, hole: 1, score: 5, putter: 2};
				var s2 = {id: r.id, group: 0, member: 0, hole: 2, score: 7, putter: 1};
				var s3 = {id: r.id, group: 0, member: 0, hole: 3, score: 9, putter: 3};
				update_scores(s1, s2, s3);
			}
		});
	});	
});
