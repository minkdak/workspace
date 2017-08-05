var viewTags = $('.bit-view'),
    newTags = $('.bit-new'),
    fiNo = $('#fi-no'),
    fiEmail = $('#fi-email'),
    fiName = $('#fi-name'),
    fiTel = $('#fi-tel'),
    fiPassword = $('#fi-password'),
    fiHomepage= $('#fi-homepage'),
    fiFacebook= $('#fi-facebook'),
    fiTwitter = $('#fi-twitter');

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
      'password': fiPassword.val(),
      'homepage': fiHomepage.val(),
      'facebook': fiFacebook.val(),
      'twitter': fiTwitter.val(),
    }, function(result) {
      // console.log(result)
      location.href = 'index.html'
    }, 'json')// 포스트요청
  })
} else { // 학생 정보 조회
  newTags.css('display', 'none')
  $.getJSON('detail.json', {'no': no}, function(result) { // 서버에서 결과를 받았으면 result에서 결과 꺼냄
    var data = result.data
    fiNo.text(data.no)
    fiEmail.val(data.email)
    fiName.val(data.name)
    fiTel.val(data.tel)
    fiHomepage.val(data.homepage)
    fiFacebook.val(data.facebook)
    fiTwitter.val(data.twitter)
  })

  $('#upd-btn').click(function() {
    $.post('update.json', {
      'no': fiNo.text(),
      'email': fiName.val(),
      'name': fiName.val(),
      'tel': fiTel.val(),
      'password': fiPassword.val(),
      'homepage': fiHomepage.val(),
      'facebook': fiFacebook.val(),
      'twitter': fiTwitter.val(),
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
