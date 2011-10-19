$(function() {
    $("div[data-role*='page']").live('pageshow', function(event, ui) {
    	if (this.id == 'card') {
    		// test to add to table 
    		var table = $('#hoge');
    		for (var i = 0; i < 4; i++) {
    		    var tr = $('<tr>');
    		    tr.append($('<td>').text('User' + i));
    		    for (var j = 0; j < 9; j++) {
    			tr.append($('<td>').text(j));
    		    }
    		    table.append(tr);
    		}
    	}
    });
});