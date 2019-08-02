/*jslint browser: true*/
/*global $, jQuery*/
$(function ($) {

    "use strict";

    var nextas = $(".next a");
    var prevas = $(".previous a");

    var index = $(location).attr('pathname').split("/").pop().split('.')[0] * 1;
    var nxt = (index + 1) + '.htm';
    var prv = (index - 1) + '.htm';

    $.each(nextas, function() {
        $(this).attr('href', nxt);
    });
    $.each(prevas, function() {
        $(this).attr('href', prv);
    });
}(jQuery));