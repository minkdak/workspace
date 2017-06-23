// 서버에서 학생 먹록 데이터를 받아온다.

// $.get('list.json', {'pageNo':1, 'pageSize': 4}, function(result) {
  // var obj = JSON.parse(result) //  문자열 파싱해서 자바스크립트 객체로 만들어서
  // console.log(result) // 객체로 출력
// },'json') //제이슨 형식으로 받아온다.
// 서버에서 받은 데이터가 제이슨이라고 알려줘야지 자바스크립트로 받아서 넘겨준다.result
// 서버에서 데이터를 보낼때 content type 헤더에 application json이라고 미리 선언한경우 ,'json' 생략해도 된다.

// 하지만 안해줘도 될 때는 확실할 때.
var pageNoTag = $('#page-no'),
    tbody = $('#student-tbl > tbody')
    prevBtn = $('#prev-btn'),
    nextBtn = $('#next-btn'),
    pageSize = 4;
var currPageNo = parseInt($('pageNoTag').text())//3)현재 페이지값 꺼내기

displayList(1)

function displayList(pageNo) {
  $.getJSON('list.json', {'pageNo': pageNo, 'pageSize': pageSize}, function(result) {
    var list = result.list;
    var totalCount = result.totalCount;
    var lastPageNo = parseInt(totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0)

    //템플릿 소스를 가지고 템플릿을 처리할 함수를 얻는다.
    var templateFn = Handlebars.compile($('#tbody-template').text())
    var generatedHTML = templateFn(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
    tbody.text('')//html로 해도됨 // tbody의 기존 tr태그들을 지우고
    tbody.html(generatedHTML) // text안됨 // 새 tr태그들로 설정한다.

    currPageNo = pageNo // 항상 현재 페이지의 번호를 가지고 있고
    pageNoTag.text(currPageNo) // 출력

    if(currPageNo == 1) {
      prevBtn.prop('disabled', true)
    } else {
      prevBtn.prop('disabled', false)
    }

    if(currPageNo == lastPageNo) {
      nextBtn.prop('disabled', true)
    } else {
      nextBtn.prop('disabled', false)
    }
  })// getJSON() 위의 코드르 파라미터값을 안주고 바로 처리하도록 함수를 만들었다.
}//displayList

prevBtn.click(function() {//2)클릭 이벤트 추가하기
  // console.log(currPageNo - 1)
  // var currPageNo = parseInt('pageNoTag').text()
  displayList(currPageNo - 1)
})
nextBtn.click(function() {
  // console.log(currPageNo + 1)
  // var currPageNo = parseInt('pageNoTag').text()
  displayList(currPageNo + 1)
})
