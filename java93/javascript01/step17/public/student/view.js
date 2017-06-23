var viewTags = $('.bit-view'),
    newTags = $('.bit-new'),
    fiNo = $('#fi-no'),
    fiEmail = $('#fi-email'),
    fiName = $('#fi-name'),
    fiTel = $('#fi-tel'),
    fiSchoolName = $('#fi-school-name'),
    fiWorking = $('#fi-working');


var no = 0

try { //예외
  no = location.href.split('?')[1].split('=')[1] // ?로 자르자
} catch(err) {} //무시

if (no == 0) { // 새 학생 등록
  viewTags.css('display', 'none')

  $('#add-btn').click(function() {
    $.post('add.json', {
      'email': fiEmail.val(),
      'name': fiName.val(),
      'tel': fiTel.val(),
      'schoolname': fiSchoolName.val(),
      'working': (fiWorking.prop('checked') ? 'Y' : 'N')

    }, function(result) {
      // console.log(result)
      location.href = 'index.html'
    }, 'json')// 포스트요청
  })
} else { // 학생 정보 조회
  newTags.css('display', 'none')
  $.getJSON('detail.json', {'no': no}, function(result) { // 서버에서 결과를 받았으면 result에서 결과 꺼냄
    // viewTags.css('display', '') // viewTags 에 대해 보여라
    fiNo.text(result.mno)
    fiEmail.val(result.email)
    fiName.val(result.name)
    fiTel.val(result.tel)
    fiSchoolName.val(result.schl_nm)
    fiWorking.prop('checked', (result.work == 'Y' ? true : false))
  })

  $('#upd-btn').click(function() {
    $.post('update.json', {
      'no': fiNo.text(),
      'email': fiName.val(),
      'name': fiName.val(),
      'tel': fiTel.val(),
      'schoolName': fiSchoolName.val(),
      'working': (fiWorking.prop('checked') ? 'Y' : 'N')

    }, function(result) {
      // console.log(result)
      location.href = 'index.html'
    }, 'json')// 포스트요청
  })

  $('#del-btn').click(function() {
    $.getJSON('delete.json', {'no': no}, function(result) {
      location.href = 'index.html'
    })
  })
}
