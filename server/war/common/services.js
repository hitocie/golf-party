
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

// me
function get_me(p) {
	async_request({
			url: '/api/v1/me/get?service=me', 
			success_handler: function(data, status) {
				//alert(JSON.stringify(data));
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
function get_all_courses(p) {
	async_request({
		url: '/api/v1/course/get?service=all_courses',
		success_handler: function(data, status) {
			p(data);
		}
	});
}

// round
function create_round(round) {
	var response = sync_request({
		url: '/api/v1/round/update', 
		data: JSON.stringify(round),
		type: 'POST'
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

