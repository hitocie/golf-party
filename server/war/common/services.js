
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
		dataType: 'json',
		cache: false,
		contentType: 'application/json; charset=utf-8',
		success: success_handler,
		error: error_handler
	});
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
function create_course(course, p) {
	async_request({
			url: '/api/v1/course/update', 
			success_handler: function(data, status) {
				//alert(JSON.stringify(data));
				p(data);
			},
			data: JSON.stringify(course),
			type: 'POST'
	});
}