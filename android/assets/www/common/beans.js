
// access token for Facebook
var _access_token_name = 'facebook-access-token';
function save_access_token(key) {
	// use localStorage of PhoneGap
	window.localStorage.setItem(_access_token_name, key);
}
function get_access_token() {
	// use localStorage of PhoneGap
	return window.localStorage.getItem(_access_token_name);
}


// ----- beans -----

// User (me and friends)
var User = function(id, name) {
	this.id = id;
	this.name = name;
};

// Group
var Group = function() {
	this.users = new Array();
};
Group.prototype.add_user = function(user) {
	this.users.push(user);
};

/*
// Hole
var Hole = function(no, par, back_yard, white_yard, red_yard, handicap) {
	this.no = no;
	this.par = par;
	this.back_yard = back_yard;
	this.white_yard = white_yard;
	this.red_yard = red_yard;
	this.handicap = handicap;
};

// Half
var Half = function(name) {
	this.name = name; // IN or OUT or ...
	this.holes = new Array(9);
};
Half.prototype.add_hole = function(hole) {
	this.holes.push(hole);
};

// Course
var Course = function(name, address) {
	this.name = name;
	this.address = address;
	this.halfs = new Array();
};
Course.prototype.add_half = function(half) {
	this.halfs.push(half);
};

// Score per one hole
var Score = function(score, putter, club, fairway, beach, penalty) {
	this.score = score;
	this.putter = putter;
	this.club = club;
	this.fairway = fairway;
	this.beach = beach; // bool
	this.penalty = penalty; // bool
};

// RoundMember
var RoundMember = function(user) {
	this.user = user;
	this.scores = new Array(18); // hole.1 - 18
};
RoundMember.prototype.set_socre = function(hole, score) {
	this.scores[hole] = score;
}

// RoundGroup
var RoundGroup = function() {
	this.members = new Array(4); // max 4 members
};
RoundGroup.prototype.add_member = function(member) {
	this.members.push(member);
};

// Round
var Round = function(course, date, weather, wind, first_half, later_half) {
	this.course = course;
	this.date = date;
	this.weather = weather;
	this.wind = wind;
	this.first_half = first_half; // IN or OUT
	this.later_half = later_half; // IN or OUT
	
	this.groups = new Array();
};
Round.prototype.add_group = function(group) {
	this.groups.push(round_group);
}

*/
