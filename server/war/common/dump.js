
function dump_user(user, tag) {
	if (tag == undefined)
		tag = '[User]';
	console.log(
			tag +
			' id=' + user.id + 
			' name=' + user.name + 
			//' token=' + user.token + 
			' timestamp=' + user.timestamp
	);
}

function dump_course(course, tag) {
	if (tag == undefined)
		tag = '[Course]';
	console.log(
			tag +
			' name= ' + course.name + 
			' address=' + course.address +
			' timestamp=' + course.timestamp 
	);
}

function dump_round(round, tag) {
	if (tag == undefined)
		tag = '[Round]';
	console.log(
			tag +
			' course= ' + round.course +
			' timestamp= ' + round.timestamp +
			' date= ' + round.date +
			' groups= ' + round.groups
	);
}
