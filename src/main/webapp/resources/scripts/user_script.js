/**
 * Created by nguyenthanhtung on 21/05/2017.
 */
$(document).ready(function(){
    var loading = $('#loading');
    var type = loading.attr('type');
    if (type === 'cover'){
        onlyItemSelected('.cover_history', '.lipsync_history', '.playlist_history');
    } else if (type === 'lipsync'){
        onlyItemSelected('.lipsync_history', '.cover_history', '.playlist_history');
    } else if (type === 'playlist'){
        onlyItemSelected('.playlist_history', '.cover_history', '.lipsync_history');
    }
    function onlyItemSelected(a, b, c) {
        $(a).addClass('selected');
        $(b + ', ' + c).removeClass('selected');
    }
});