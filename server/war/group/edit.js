function parse_query(q) {
	var exps = q.substr(1).split('&');
	var results = [];
	for (var i = 0 in exps) {
		var p = exps[i].split('=');
		results[p[0]] = p[1];
	}
    return results;
}

$(function() {
    $("div[data-role*='page']").live('pageshow', function(event, ui) {
    	if (this.id == 'group-edit') {
    	    var v = parse_query(location.search);
    	    var from = v['from'];
    	    if (from == 'list') {
        	    console.log('Choice row=' + v['row']);
    	    	var members = $('#members');
    	    	members.listview();
    	    	members.empty(); // removed
    	    	for (var i = 0; i < 10; i++)
    	    		members.append('<li>めんばー' + i + '</li>');
    	    	members.listview('refresh');
    	    	
    	    } else if (from == 'friends') {
    	    	console.log(v['name']);
    	    	// TODO: Add friend to Group.
    	    } 
    	}
    });
});