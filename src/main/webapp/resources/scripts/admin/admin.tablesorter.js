$(function () {

    var $table = $('table').tablesorter({
        theme: 'default',
        widgets: ["zebra", "filter"],
        widgetOptions: {
            // filter_anyMatch replaced! Instead use the filter_external option
            // Set to use a jQuery selector (or jQuery object) pointing to the
            // external filter (column specific or any match)
            filter_external: '.search',
            // add a default type search to the first name column
            filter_defaultFilter: {1: '~{query}'},
            // include column filters
            filter_columnFilters: true,
            filter_placeholder: {search: 'Search...'},
            filter_saveFilters: true,
            filter_reset: '.reset'
        }
    });
    $(".tablesorter thead tr:nth-child(2) td:nth-child(1) input, .tablesorter thead tr:nth-child(2) td:nth-child(3) input")
        .prop("disabled", true)
        .attr("placeholder", "Disabled")
        .css("background-color", "#ccc");

});