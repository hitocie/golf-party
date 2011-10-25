$(function() {
    $("div[data-role*='page']").live('pageshow', function(event, ui) {
    	if (this.id == 'friend-list') {
    		get_my_friends(function(friends) {
        	    var lv = $('#friends');
        	    lv.listview();
        	    lv.empty(); // removed
        		for (var i = 0 in friends) {
        			var f = friends[i];
        			lv.append('<li><a href="edit.html?from=friends&id=' + f.id + '&name=' + f.name + '">' + f.name + '</a></li>');
        		}
        		lv.listview('refresh');
    		});
    	}
    });
});