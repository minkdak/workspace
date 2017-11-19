SandwichModel = Backbone.Model.extend({
  defaults: {
    bread: "wheat"
  },
  initialize: function() {
    this.bindEvents();
  },
  bindEvents: function() { //커스텀메서드
    this.on("change:bread", function(model) {
      var my_new_bread = model.get("bread")
      alert("Hey! The bread changed to: " + my_new_bread);
    });
  }
});

$(document).ready(function() {
  var my_sandwich = new SandwichModel();
  my_sandwich.set({bread: "jalapeno"});
  my_sandwich.set({bread: "big weiner"});
})
