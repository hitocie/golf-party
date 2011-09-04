
// --- facebook api ---

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

