
var Invoker = function(server_url){
	this.server_url = server_url;
	this.sid = null;
};

Invoker.prototype = {
	
	create_user : function(username, password, email) {
		var url = this.server_url + "?action=create_user&username=" + username +
			"&password=" + password + "&email=" + email;
		$.ajax({
			url: url,
			type: "GET",
			dataType: "json",
			cache: false,
			//contentType: "application/json; charset=utf-8",
			success: function(data, status){
				alert("success!" + data);
			},
			error: function(data, status){
				alert("error!! " + JSON.stringify(data));
			}
		});

	},

	login: function(username, password){
		var server_url = this.server_url;
		var url = server_url + "?action=handshake&username=" + username;
		var sid = null;
		$.ajax({
			url: url,
		 	type: "GET",
	 		dataType: "json",
	 		cache: false,
	 		async: false,
	 		//contentType: "application/json; charset=utf-8",
	 		success: function(data, status) {
				var header = data[0];
				var body = data[1];
				if (body.has_succeeded) {
					sid = body.sid;
					var onetime_password = body.onetime_password;
					var enc_password = Crypto.HMAC(Crypto.SHA1, password, onetime_password);
					var login_url = server_url + "?action=login&sid=" + sid + "&password=" + enc_password;
					$.ajax({
						url: login_url,
						type: 'GET',
						dataType: 'json',
						cache: false,
						async: false,
						success: function(data, status) {
							var body = data[1];
							if (body.has_succeeded) {
								alert("Logged in!!");
							}
						},
						error: function(data) {
							alert('error!!' + data);
						}
					});
				}
	 		},
	 		error: function(data) {
	 			alert("error!!" + JSON.stringify(data));
	 		}
	 	});
		//HACK! cannot set to this.sid in closure.
		this.sid = sid; 
	},
	
	logout : function() {
		var url = this.server_url + "?action=logout&sid=" + this.sid;
		$.ajax({
			url: url,
			type: "GET",
			dataType: "json",
			cache: false,
			async: false,
			//contentType: "application/json; charset=utf-8",
			success: function(data, status){
				alert("success!" + JSON.stringify(data));
			},
			error: function(data, status){
				alert("complete!! " + JSON.stringify(data) + " " + status + " ");
			}
		});
	},
	
	
	invoke : function(service_name, method_name, args) {
		var app_name = "AppTest";
		var app_version = "1.0";
		var client_type = "android";
		var client_version = "2.3";
		var header = 
		{"sid": this.sid,
		 "app_name": app_name,
		 "app_version": app_version,
		 "service_name": service_name,
		 "method_class": method_name
		};
		var body = {"args": [args]};
		var req = [header, [body]];
		alert(JSON.stringify(req));
		var url = this.server_url;
		$.ajax({
			url: url,
			type: 'POST',
			dataType: "json",
			contentType: "application/json; charset=utf-8",
			processData: false,
			data: JSON.stringify(req),
			//cache: false,
			async: false,
			success: function(data, status){
				alert("success!" + JSON.stringify(data));
			},
			error: function(data, status){
				alert("complete!! " + JSON.stringify(data) + " " + status + " ");
			}
		});
	}
};

var invoker = null;
// event handlers
$(function() {
	$("#create_user").click(function() {
		invoker = new Invoker('http://10.41.68.71:8888/controller_server');
		invoker.create_user("hokada", "pass", "hokada@test.com")
	});	
}
);

$(function() {
	$("#login").click(function() {
		invoker = new Invoker('http://10.41.68.71:8888/controller_server');
		invoker.login("hokada", "pass");
	});	
}
);

$(function() {
	$("#logout").click(function() {
		invoker.invoke("com.fw.server.service.user.UserService", "deleteUser", {"username":"hokada"});
		invoker.logout();
	});	
}
);
