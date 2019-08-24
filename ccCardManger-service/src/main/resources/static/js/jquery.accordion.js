(function(jQuery) {
  jQuery.fn.accordion = function(options) {
    var settings = jQuery.extend({}, {open: false}, options);
    return this.each(function() {
      var dts = jQuery(this).children('dt');
      dts.click(onClick);
      dts.each(reset);
      if(settings.open) {
        jQuery(this).children('dt').eq(0).next().show();
        jQuery(this).children('dt').eq(0).children('.quote-btn').hide();
      }
    });
    function onClick() {
      jQuery(this).siblings('dt').each(hide);
      jQuery(this).next().slideDown('fast');
      jQuery(this).children('.quote-btn').hide();
      jQuery(this).siblings('dt').children('.quote-btn').show();
      return false;
    }
    function hide() {
      jQuery(this).next().slideUp('fast');
    }
    function reset() {
      jQuery(this).next().hide();
    }
  }
})(jQuery);
