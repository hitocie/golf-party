
// User (me and friends)
var UserWhere = {local:0, facebook:1, google_plus:2};
var User = function(id, name, where) {
	this.id = id;
	this.name = name;
	this.where = (arguments[2] ? where : UserWhere.local);
};

// Group
var Group = function(name) {
	this.name = name;
	this.users = new Array();
};
Group.prototype.add_user = function(user) {
	this.users.push(user);
};

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
	this.holes = new Array(); // max 9 holes
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
	this.scores = new Array(); // hole.1 - 18
};
RoundMember.prototype.set_score = function(hole, score) {
	this.scores[hole] = score;
}

// RoundGroup
var RoundGroup = function() {
	this.round_members = new Array(); // max 4 members
};
RoundGroup.prototype.add_round_member = function(round_member) {
	this.round_members.push(round_member);
};

// Weather/Wind
var Weather = {fine:'ê∞ÇÍ', cloudy:'ì‹ÇË', rainy:'âJ', snow:'ê·'};
var Wind = {strong:'ã≠Ç¢', weak:'é„Ç¢', no:'Ç»Çµ'};

// Round
var Round = function(course, date, weather, wind, first_half, later_half) {
	this.id = null; // assign on server-side.
	this.course = course;
	this.date = date;
	this.weather = weather;
	this.wind = wind;
	this.first_half = first_half; // IN or OUT or others
	this.later_half = later_half; // IN or OUT or others
	
	this.round_groups = new Array();
};
Round.prototype.add_round_group = function(round_group) {
	this.round_groups.push(round_group);
}
