"use strict"
window.$ = window.jQuery = require('jquery')


var tbody = $('#student-tbl > tbody')

displayList(1)

$('#add-btn').click(function() {
  location.href = 'view.html'
})

$('#prev-btn').click(function() {
  var currPageNo = parseInt($('#page-no').text())//현재화면에서.
  displayList(currPageNo - 1)
})

$('#next-btn').click(function() {
  var currPageNo = parseInt($('#page-no').text())
  displayList(currPageNo + 1)

})

function displayList(pageNo) {
  selectListStudent(
    pageNo,
    function(results) {
      tbody.html('');

      for (var i = 0; i < 3; i++) {
        if(i < results.length) {
          let s = results[i]
          $("<tr>").html("<td>" + s.mno +
          "</td><td><a href='#' data-no='" + s.mno + "' class='view-link'>" + s.name +
          "</a></td><td>" + s.tel +
          "</td><td>" + s.email +
          "</td><td>" + (s.work == "Y" ? "재직중" : "실업") + "</td>")
          .appendTo(tbody)
        } else {
          $("<tr><td colspan='5'>&nbsp;</td></tr>").appendTo(tbody)
        } //else
      } //for
      $('table .view-link').click(onClickViewLink)
      preparePagingBar(pageNo)
    }, //function(results),
    function(error) {
      alert('데이터 조회 중 발생!')
      throw error;
  })  //selectListStudent
}


function preparePagingBar(pageNo) {
  $('#page-no').text(pageNo)

  if(pageNo == 1) {
    $('#prev-btn').attr('disabled', true)
  } else {
    $('#prev-btn').attr('disabled', false)
  }

countAllStudent(
  function(results) {
    var totalCount = results[0].cnt;
    var totalPage = parseInt(totalCount / 3) + (totalCount % 3 > 0 ? 1 : 0);

    if (pageNo == totalPage) {
      $('#next-btn').attr('disabled', true)
    } else {
      $('#next-btn').attr('disabled', false)
    }
  },
  function(error) {
    alert('데이터 조회 중 발생!')
    throw error;
  }) //countAllStudent
}

function onClickViewLink(event) {
  location.href = 'view.html?no=' + $(this).attr('data-no')
  event.preventDefault()
}
