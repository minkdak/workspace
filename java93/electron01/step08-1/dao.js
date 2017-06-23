// index.html에 있는 html, css, javascript 분리 -javascript 분리
"use strict"
const mysql = require('mysql')
const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
connection.connect()

function selectListStudent(pageNo, successFn, errorFn) {
  // 데이터 처리해 줄게. 페이지넘버줘봐 ->
  // success, errorFn 성공,에러시 호출될 함수 등록
  connection.query(
    'select m.mno, m.name, m.tel, m.email, s.work \
    from stud s inner join memb m on s.sno=m.mno  \
    order by m.name asc \
    limit ?, ?',
    [pageNo-1) * 3, 3] // 앞에 물음표자리에는 ,앞까지 들어가고 뒤에 물음표 마찬가지.
    function(error, results) {
      if (error) {
        alert('데이터 조회 중 오류 발생!')
        throw error;

      } else {
        successFn(results)
      }
})


      // 기존에 있던 tr 태그 삭제


      for (var i = 0; i < 3; i++) {
        if (i < results.length) {
          let s = results[i]
          $("<tr>").html("<td>" + s.mno +
          "</td><td><a href='#' data-no='" + s.mno + "' class='view-link'>" + s.name +
          "</a></td><td>" + s.tel +
          "</td><td>" + s.email +
          "</td><td>" + (s.work == "Y" ? "재직중" : "실업") + "</td>")
          .appendTo(tbody)
        } else {
          $("<tr><td colspan='5'>&nbsp;</td></tr>").appendTo(tbody)
        }
      }

      $('table .view-link').click(onClickViewLink)

      preparePagingBar(pageNo)

      console.log('list 가져오는 거 처리끝!')
    }) // connection.query()

  console.log('listStudent() 호출 끝!!!')
}

function preparePagingBar(pageNo) {
  $('#page-no').text(pageNo)

  if (pageNo == 1) {
    $('#prev-btn').attr('disabled', true)
  } else {
    $('#prev-btn').attr('disabled', false)
  }

function countAllStudent(successFn, errorFn) {
  connection.query(
    'select count(*) cnt from stud',
    function(error, results) {
      if (error) {
        alert('데이터 조회 중 발생!')
        throw error;
      } else {
        successFn(results)
      }
      }
    }) //connection.query()
}


<!-- -->
