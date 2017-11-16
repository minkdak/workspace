WebsiteModel = Backbone.Model.extend({ //  모델생성, 생성자함수
  initialize: function() {
      alert("Hello Mommy");
  }
});

$(document).ready(function() {
  var page_1 = new WebsiteModel(); //WebsiteModel인스턴스
})



