/**
 * Created by nguyenthanhtung on 15/05/2017.
 */
$(document).ready(function(){
    $('#select_date').on('click',function(){
        var startDate;
        var endDate;

        var selectCurrentWeek = function() {
            window.setTimeout(function () {
                $('#select_date').find('.ui-datepicker-current-day a').addClass('ui-state-active')
            }, 1);
        };

        $('#select_date').datepicker( {
            showOtherMonths: true,
            selectOtherMonths: true,
            onSelect: function(dateText, inst) {
                var date = $(this).datepicker('getDate');
                startDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay());
                endDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay() + 6);
                var dateFormat = inst.settings.dateFormat || $.datepicker._defaults.dateFormat;
                // $('#startDate').text($.datepicker.formatDate( dateFormat, startDate, inst.settings ));
                // $('#endDate').text($.datepicker.formatDate( dateFormat, endDate, inst.settings ));

                selectCurrentWeek();
            },
            beforeShowDay: function(date) {
                var cssClass = '';
                if(date >= startDate && date <= endDate)
                    cssClass = 'ui-datepicker-current-day';
                return [true, cssClass];
            },
            onChangeMonthYear: function(year, month, inst) {
                selectCurrentWeek();
            }
        });

        $('.week-picker .ui-datepicker-calendar tr').mouseover( function() { $(this).find('td a').addClass('ui-state-hover'); });
        $('.week-picker .ui-datepicker-calendar tr').mouseout( function() { $(this).find('td a').removeClass('ui-state-hover'); });
    });
});