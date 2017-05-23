/**
 * Created by Khanh Nguyen on 22/5/2017.
 */
$(function () {
    $("tr button").on("click", function () {
        var self = $(this);
        var trCurrent = self.parentsUntil("tr").parent();
        var trNext = trCurrent.next();    
        if (self.text().trim() === "+") {
            self.text("-");
            trNext.slideDown();
        } else {
            self.text("+");
            trNext.slideUp();
        }
    });
});