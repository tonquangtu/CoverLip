/**
 * Created by nguyenthanhtung on 15/05/2017.
 */
$(document).ready(function(){
    var urlServer = 'http://localhost:8080/top-cover';
    $('#select_date').on('click',function(){
        if($('.ui-datepicker').css('display') ==='none'){
            $('.ui-datepicker').show();
        }else{
            $('.ui-datepicker').hide();
        }
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
                var nowDate = new Date(date.getFullYear(), date.getMonth(), date.getDate());
                startDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay());
                endDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay() + 6);
                var dateFormat = inst.settings.dateFormat || $.datepicker._defaults.dateFormat;
                startDate = $.datepicker.formatDate( dateFormat, startDate, inst.settings );
                endDate = $.datepicker.formatDate( dateFormat, endDate, inst.settings );
                nowDate = $.datepicker.formatDate(dateFormat, nowDate, inst.settings);

                selectCurrentWeek();
                $('.ui-datepicker').hide();
                $.ajax({
                    type:"POST",
                    url:urlServer+"/get-num-week",
                    data:{timestamp:new Date(nowDate).getTime()},
                    success:function(data){
                        window.location=urlServer+"/Bang-Xep-Hang-Lan-" + data;
                    },
                    error:function(){
                    }
                });
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

    //Set default when click outer
    $(document).click(function (e) {
        var container = $('#select_date');

        if (!container.is(e.target) && container.has(e.target).length === 0) {
            $('.ui-datepicker').hide();
        }
    });
});