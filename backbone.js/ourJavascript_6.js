/* View란

 */
TheView = Backbone.View.extend({
  defaults: {

  },
  initialize: function() {
    console.log(this.el);
    console.log(this.$el); // 자주씀 HTML코드와 쉽게 연결해서 사용할 수 있음.
    this.$el.append("lalalalalalhahahahahaha");
  }
})

$(document).ready(function() {
  var aView = new TheView({el: $("#unique")}); // el 프로퍼티를 만든다
});

/*

el : 돔 객체를 참조( references a DOM object)
$el : 돔객체를 참조하는 것처럼 jquery 객체를 참조(it is  a jQuery object that still refrences the same DOM object as el)

*/
