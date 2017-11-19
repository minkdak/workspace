/* View란

 */
TheView = Backbone.View.extend({
  defaults: {

  },
  initialize: function() {
    alert("I Exist NOW. MWA HA HA HA HA!");
  }
})

$(document).ready(function() {
  var aView = new TheView();
});
