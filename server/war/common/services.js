
// common
var error_handler = function(data, status) {
	alert("error!! " + JSON.stringify(data));
};

function async_request(args) {
	
	var url = args.url;
	var success_handler = args.success_handler;
	var data = args.data;
	var type = args.type;
	if (type == undefined)
		type = 'GET';
	
	$.ajax({
		url: url,
		data: data,
		type: type,
		async: true,
		dataType: 'json',
		cache: false,
		contentType: 'application/json; charset=utf-8',
		success: success_handler,
		error: error_handler
	});
}
function sync_request(args) {

	var url = args.url;
	var data = args.data;
	var type = args.type;
	if (type == undefined)
		type = 'GET';
	
	var response = $.ajax({
		url: url,
		data: data,
		type: type,
		async: false,
		dataType: 'json',
		cache: false,
		contentType: 'application/json; charset=utf-8'
	}).responseText;
	
	return JSON.parse(response);
}


// auth
function login_local(id, name, p) {
	async_request({
			url: '/api/v1/auth/local/',
			success_handler: function(data, status) {
				p(data);
			},
			data: {id: id, name: name}
	});
}
function is_login() {
	return sync_request({
		url: '/api/v1/auth/facebook/check?service=login'
	});
}

// me
function get_me(p) {
	async_request({
		url: '/api/v1/me/get?service=me', 
		success_handler: function(data, status) {
			p(data);
		}
	});
}
function get_my_friends(p) {
	// TODO: get from cache if possible.
	remove_storage('friends'); // TODO: delete this line.
	var friends = get_storage('friends');
	if (friends != null)
		p(friends);
	
	async_request({
		url: '/api/v1/me/get?service=my_friends',
		success_handler: function(data, status) {
			set_storage('friends', data); // caching
			p(data);
		}
	});
}

// course
function create_course(course) {
	var response = sync_request({
			url: '/api/v1/course/update', 
			data: JSON.stringify(course),
			type: 'POST'
	});
	return response;
}
function delete_course(course) {
	var response = sync_request({
		url: '/api/v1/course/update',
		data: JSON.stringify({id: course.id}),
		type: 'DELETE'
	});
	return response;
}

function get_all_areas(p) {
	async_request({
		url: '/api/v1/course/get?service=all_areas',
		success_handler: function(data, status) {
			p(data);
		}
	});
}
function get_all_courses(p) {
	async_request({
		url: '/api/v1/course/get?service=all_courses',
		success_handler: function(data, status) {
			p(data);
		}
	});
}
function find_courses(area, keyword, p) {
	async_request({
		url: '/api/v1/course/get?service=find_courses',
		data: {area: area, keyword: keyword},
		success_handler: function(data, status) {
			p(data);
		}
	});
}

// round
var Weather = {
		fine: 0,
	    cloudy: 1,
	    rainy: 2,
	    snow: 3
};
var Wind = {
	    strong: 0,
	    weak: 1,
	    no: 2
};

function create_round(round) {
	var response = sync_request({
		url: '/api/v1/round/update', 
		data: JSON.stringify(round),
		type: 'POST'
	});
	return response;
}
function update_scores() {
	var data = [];
	for (var i = 0; i < arguments.length; i++) {
		var s = arguments[i];
		s.hole = s.hole - 1;
		data.push(s);
	}
	var response = sync_request({
		url: '/api/v1/round/update',
		data: JSON.stringify({scores: data}),
		type: 'PUT'
	});
	return response;
}
function delete_round(round) {
	var response = sync_request({
		url: '/api/v1/round/update',
		data: JSON.stringify({id: round.id}),
		type: 'DELETE'
	});
	return response;
}

function get_all_rounds(p) {
	async_request({
		url: '/api/v1/round/get?service=all_rounds',
		success_handler: function(data, status) {
			p(data);
		}
	});
}
function get_my_rounds(p) {
	async_request({
		url: '/api/v1/round/get?service=my_rounds',
		success_handler: function(data, status) {
			p(data);
		}
	});
}
function get_round(id, p) {
	async_request({
		url: '/api/v1/round/get?service=round',
		data: {id: id},
		success_handler: function(data, status) {
			p(data);
		}
	});
}


// group
function get_my_groups(p) {
	async_request({
		url: '/api/v1/me/get?service=my_groups',
		success_handler: function(data, status) {
			var groups = data;
			get_my_friends(function(friends) {
				for (var i in groups) {
					var group = groups[i];
					var users = [];
					for (var j in group.userids) {
						var u = group.userids[j];
						for (var k in friends) {
							var f = friends[k];
							if (f.id == u) {
								users.push({id: f.id, name: f.name});
								break;
							}
						}
					}
					group.users = users;
					delete group.userids;
				}
				p(groups);
			});
		}
	});
}
function create_group(group) {
	var response = sync_request({
		url: '/api/v1/me/update', 
		data: JSON.stringify(group),
		type: 'POST'
	});
	return response;
}
function update_group(group) {
	var response = sync_request({
		url: '/api/v1/me/update',
		data: JSON.stringify(group),
		type: 'PUT'
	});
	return response;
}
function delete_group(group) {
	var response = sync_request({
		url: '/api/v1/me/update',
		data: JSON.stringify({id: group.id}),
		type: 'DELETE'
	});
	return response;
}