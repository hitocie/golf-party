
$('#group-add').live('pageshow', function(event, ui) {
	// do nothing
});

$('#group-add').live('pagehide', function(event, ui) {
	//$('#group-add').die('pageshow');
});



$(function() {
	$('#added').click(function() {
		var new_group = $('#group-name').val()
		if (new_group != '') {
			set_storage('new-group', new_group);
		}
		$.mobile.changePage(
				'list.html', 'pop', false, false
		);
	});	
});

