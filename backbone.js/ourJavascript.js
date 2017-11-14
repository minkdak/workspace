WebsiteModel = Backbone.Model.extend({
  initialize: function() {
      alert("Hello Mommy");
  }
});

$(document).ready(function() {
  var page_1 = new WebsiteModel();
})
