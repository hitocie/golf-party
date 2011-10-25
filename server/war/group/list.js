$(function() {
    $("div[data-role*='page']").live('pageshow', function(event, ui) {
    	if (this.id == 'group-list') {
    		var groups = $('#groups');
    		groups.listview();
    		groups.empty(); // removed
    		for (var i = 0; i < 10; i++) {
    			groups.append('<li><a href="edit.html?from=list&row=' + i + '">グループ' + i + '</a></li>');
    		}
    		groups.listview('refresh');
    	}
    });
});
