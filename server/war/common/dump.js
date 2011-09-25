
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
			' id=' + course.id + 
			' name=' + course.name + 
			' address=' + course.address +
			' timestamp=' + course.timestamp 
	);
}

function dump_round(round, tag) {
	if (tag == undefined)
		tag = '[Round]';
	console.log(
			tag +
			' id=' + round.id + 
			' course=' + round.course.name +
			' timestamp=' + round.timestamp +
			' date=' + round.date +
			' groups=' + JSON.stringify(round.groups)
	);
}
