
// --- Common ---
var server_url = 'http://192.168.11.2:8888';

function login() {
	$.ajax({
		url: server_url + '/me/?service=login' + 'access_token',
		type: 'GET',
		//dataType: 'json',
		cache: false,
		//contentType: "application/json; charset=utf-8",
		success: function(data, status){
			alert("success!" + data);
		},
		error: function(data, status){
			alert("error!! " + JSON.stringify(data));
		}
	});
}
function get_me() {
	$.ajax({
		url: server_url + '/me/?service=get_me',
		type: 'GET',
		dataType: 'json',
		cache: false,
		//contentType: "application/json; charset=utf-8",
		success: function(data, status){
			alert("success!" + data);
		},
		error: function(data, status){
			alert("error!! " + JSON.stringify(data));
		}
	});
}


var CRUD = {c:0, r:1, u:2, d:3};


// --- User ---

// get my friends.
function sync_my_friends() {
	// FIXME: Should communicate with server-side, and then, update local database.	
}
function get_my_friends() {
	
	sync_my_friends();
	
	// TODO: get from local database.
	var users = new Array();
	users.push(new User(100, 'Hitoshi Okada', UserWhere.facebook));
	users.push(new User(200, 'Yuki Arai', UserWhere.facebook));
	users.push(new User(300, 'Nao Okamoto', UserWhere.facebook));
	users.push(new User(400, 'Akira Mori', UserWhere.google_plus));
	users.push(new User(500, 'Shingo Nishimura', UserWhere.facebook));
	users.push(new User(600, 'Hiroki Mino', UserWhere.google_plus));
	users.push(new User(700, 'Takayuki Yoshida', UserWhere.facebook));
	users.push(new User(800, 'Moe Shiratori'));
	users.push(new User(900, 'Shiomi-chi', UserWhere.facebook));
	users.push(new User(1000, 'TAKESHI'));
	users.push(new User(1100, 'Kuro'));
	users.push(new User(1200, 'Umemura'));
	return users;
}


// --- Course ---
function sync_courses() {
	// FIXME: Should communicate with server-side, and then, update local database.	
}
function get_courses() {
	
	sync_courses();
	
	// TODO: get from local database.
	var courses = new Array();
	for (var i = 0; i < 20; i++) {
		var out_half = new Half('OUT');
		for (var j = 0; j < 9; j++) {
			out_half.add_hole(new Hole(j + 1, 5, 500, 400, 300, j + 1));
		}
		var in_half = new Half('IN');
		for (var j = 0; j < 9; j++) {
			in_half.add_hole(new Hole(j + 10, 4, 450, 350, 100, j + 10));
		}
	
		var course = new Course('Great Golf Club' + i, 'Tokyo, Japan');
		course.add_half(out_half);
		course.add_half(in_half);
		courses.push(course);
	}
	return courses;
}


// --- Round ---
function sync_round(round, crud) {
	// FIXME: Should communicate with server-side, and then, update local database.	
}
function create_round(round) {
	
	sync_round(round, CRUD.c); // NOTE: add Round.id on server-side.
	
	// TODO: SQL (local database)	
	return round;
}
function update_round(round) {
	
	sync_round(round, CRUD.u);
	
	// TODO: SQL - update scores. - (local database)
}
function delete_round(round) {
	// TODO: SQL (1.server and 2.local database)
}
function get_my_rounds() {
	var rounds = new Array();
	// TODO: SQL
	return rounds;
}


// --- Group --- (only local database.)
function create_group(group) {
	// TODO: SQL
}
function update_group(group_name) {
	// TODO: SQL	
}
function delete_group(group_name) {
	// TODO: SQL
}
function get_my_groups() {
	// TODO: SQL
}

