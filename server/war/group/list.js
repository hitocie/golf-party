$(function() {
    $("div[data-role*='page']").live('pageshow', function(event, ui) {
    	if (this.id == 'card') {

    	}
    });
});


$(function() {
	$("#move-a").click(function() {
		alert('move-a');
	});
});

$(function() {
	$("#move-b").click(function() {
		alert('move-b');
	});
});
