"use strict"


//1. 함수만들기
function createStudentService(memberDao, studentDao) {
  return { // 5개의 함수를 가진 객체를 만들어 리턴
    /* list(pageNo, success, error) 스펙
    => pageNo: 가져올 페이지의 번호
    => success: 데이터 가져오는데 성공했을 때 호출될 함수
    success(학생데이터 배열, 전체개수)
    => error: 데이터 갖오는데 실패했을 떄 호출될 함수
    error(오류객체)
    */
    list(pageNo, success, error) {
      studentDao.selectList(pageNo, function(students) {//success는 그대로 못넘긴다. select한다음에 countAll까지 해야되기 때문에
        studentDao.countAll(function(result) {
          success(students, result[0].cnt) //student 배열이 넘어온다. students는 내변수.
        }, error)
      }, error) //studentDao.select List ;pageNo를 넘겨주고.
    }, //list
    detail(no, success, error) {
      studentDao.selectOne(no, success, error)
    }, //detail
    insert(student, success, error) { // 인서트 호출하면 student 멤버 컬럼받아 5개
      memberDao.insert(student, function(result) {
        student.no = result.insertId //insertId
        // 성공했다고끝나는게아니라 다시 질의
        studentDao.insert(student, function(result2) {
          success(result2)
        }, error) // student그대로 넘김
      }, error) // 이 student에 넘기고 성공하면 성공함수 호출
    }, //insert

    update(student, success, error) {
      memberDao.update(student, function(result) {
        studentDao.update(student, success, error)
      }, error)
    }, //update
    delete(no, success, error) {
      studentDao.delete(no, function(result) {
        memberDao.delete(no, success, error)
      }, error)
    } //delete
  }
} //createSTudentService
