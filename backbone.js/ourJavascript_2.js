/*Model Attribute 2번째 방법
- 잘 안 쓰이는 방법

*/
WebsiteModel = Backbone.Model.extend({
  initialize: function() {
  }
});

$(document).ready(function() {
  var page_1 = new WebsiteModel({name: "The best website ever", barcode: 1}); // variables 초기화
  page_1.set({name: "An even coller website"});
  page_1.set({barcode: 69});
      alert("Page's 1 title is: " + page_1.get("name") + " and its barcode is: "+ page_1.get("barcode"));
})
