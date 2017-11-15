
/*Model Attribute 1번째 방법*/
 WebsiteModel = Backbone.Model.extend({
   initialize: function() {
   }
 });

 $(document).ready(function() {
   var page_1 = new WebsiteModel({name: "The best website ever", barcode: 1}); // variables 초기화
       alert("Page's 1 title is: " + page_1.get("name") + " and its barcode is: "+ page_1.get("barcode"));
 })
