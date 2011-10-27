
function to_query(jo) {
	var buf = '?';
	var count = 0;
	for (var k in jo) {
		if (count != 0)
			buf = buf + '&'
		buf = buf + k + '=' + encodeURI(jo[k]);
		count++;
	}
	return buf;
}

function parse_query(q) {
	var exps = q.substr(1).split('&');
	var results = [];
	for (var i = 0 in exps) {
		var p = exps[i].split('=');
		results[p[0]] = decodeURI(p[1]);
	}
	return results;
}


// storage
function set_storage(k, v) {
	sessionStorage.setItem(k, JSON.stringify(v));
}

function get_storage(k) {
	return JSON.parse(sessionStorage.getItem(k));
}

function remove_storage(k) {
	sessionStorage.removeItem(k);
}

function clear_storage() {
	sessionStorage.clear();
}
