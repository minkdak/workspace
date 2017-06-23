"use strict"
window.$ = window.jQuery = require('jquery')


var fiNo = $('#fi-no'),
    fiEmail = $('#fi-email'),
    fiName = $('#fi-name'),
    fiTel = $('#fi-tel'),
    fiSchoolName = $('#fi-school-name'),
    fiWorking = $('#fi-working');

if (location.search == "") {
  // 새 사용자 등록을 처리한다.
  // 상세보기와 관련된 태그는 감춘다.
  $('.bit-view').css('display', 'none')

  // 새 사용자 등록과 관련된 태그는 보이게 한다.
  $('.bit-new').css('display', '')

  // 추가 버튼에 click 이벤트 핸들러(리스너)를 등록한다.
  $('#add-btn').click(function() {
    insertMember(
      {
        name: fiName.val(),
        tel: fiTel.val(),
        email: fiEmail.val(),
        pwd: '1111'
      },
      function(result) {
      insertStudent(
        {
          no: result.insertId,
          working: (fiWorking.prop('checked') ? 'Y' : 'N'),
          schoolName: fiSchoolName.val()
        },
        function(result) {
          location.href = 'index.html'
        },//function(result)
        function(error) {
          alert('학생 데이터 등록 중 오류 발생!')
          throw error;
        }) //insertStud
      },
      function(error) {
        alert('학생 데이터 등록 중 오류 발생!')
        throw error;
      })
    })// add-btn click()

} else { // 기존 사용자 정보를 가져온다.
  // 새 사용자 등록과 관련된 태그는 감춘다.
  $('.bit-new').css('display', 'none')

  // URL에서 학생 번호(no)를 추출한다.
  var no = location.search.substring(1).split('=')[1]
  /*
  select m.mno, m.name, m.tel, m.email, s.work \
  from stud s inner join memb m on s.sno=m.mno
  where s.sno=1 // 항상먼저 확인하라.
  */
selectOneStudent(
  no,
  function(result) {
    var student = result
    fiNo.text(student.mno)
    fiEmail.val(student.email)
    fiName.val(student.name)
    fiTel.val(student.tel)
    fiSchoolName.val(student.schl_nm)
    fiWorking.attr('checked', (student.work =='Y' ? true : false))
    },
    function(error) {
      alert('학생 데이터 가져오는 중 오류 발생!')
      throw error
  })//selectOneStudent(


  $('#upd-btn').click(function() {
    // console.log(fiWorking.prop('checked'));
    // checked, selected, disabled attr 설정할 때는 상관없지만, 값을 꺼낼때는 prop를 사용한다.
      /*
      update study set work=?, schl_nm=? where sno=?
      */

      updateMember(
        {
          "no": no,
          "name": fiName.val(),
          "tel": fiTel.val(),
          "email": fiEmail.val()
        },
        function(result) {
          updateStudent(
          {
            "no": no,
            "working": (fiWorking.prop('checked') ? 'Y' : 'N'),
            "schoolName": fiSchoolName.val()
          },
          function(result) {
            alert('변경하였습니다.')
          },
          function(error) {
            alert('회원 기본데이터 변경 중 오류 발생!')
          })//updateStudent
        },
        function(error) {
          alert('회원 기본데이터 변경 중 오류 발생!')
        }
      )//updateMember
    }) // click()


    $('#del-btn').click(function() {
      deleteStudent(no,
        function(result) {
        deleteMember(no,
          function(result) {
            location.href = 'index.html'
          },
          function(error) {
            alert('학생 데이터 삭제 중 오류 발생!')
            throw error;
          })
        },
        function(error) {
          alert('학생 데이터 삭제 중 오류 발생!')
          throw error;
        })
      }) // delete
    } //esle

  $('#lst-btn').click(function() {
    location.href = "index.html"
  })



  <!-- -->
