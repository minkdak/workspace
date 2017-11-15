WebsiteModel = Backbone.Model.extend({
  defaults: {
    name: "An unknown website",
    barcode: -1
  },
  initialize: function() {
  }
});

$(document).ready(function() {
  var page_1 = new WebsiteModel();
  alert("Page's 1 title is: " + page_1.get("name") + " and its barcode is: "+ page_1.get("barcode"));
})
