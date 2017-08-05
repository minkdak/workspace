var pageNoTag = $('#page-no'),
    tbody = $('#teacher-tbl > tbody')
    prevBtn = $('#prev-btn'),
    nextBtn = $('#next-btn'),
    pageSize = 4;

var currPageNo = parseInt($('pageNoTag').text())

// 이벤트 핸들러 등록
$(document.body).on('click', '.detail-link', function(event) {
  location.href = 'view.html?no=' + $(this).attr('data-no')
  event.preventDefault()
})

prevBtn.click(function() {
	displayList(currPageNo - 1)
})
nextBtn.click(function() {
	displayList(currPageNo + 1)
})

displayList(1)
function displayList(pageNo) {
	$.getJSON('list.json', {'pageNo': pageNo, 'pageSize': pageSize}, function(result) {
		console.log(result);
		var totalCount = result.data.totalCount;
		
		var lastPageNo = parseInt(totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0)
		
		var templateFn = Handlebars.compile($('#tbody-template').text())
		var generatedHTML = templateFn(result.data) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
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
	
/*



*/