// 학생 정보를 다루는 서비스를 정의한다.
const express = require('express')
const datasource = require('../util/datasource')
const studentDao = require('../dao/student-dao')
const memberDao = require('../dao/member-dao')
const studentService = require('../service/student-service')

const connection = datasource.getConnection()
studentDao.setConnection(connection)
memberDao.setConnection(connection)
studentService.setStudentDao(studentDao)
studentService.setMemberDao(memberDao)

const router = express.Router()

router.get('/list.do', (request, response) => {
  var pageNo = 1,
      pageSize = 3;
  if (request.query.pageNo) { // 페이지 번호 조정
    pageNo = parseInt(request.query.pageNo)
  }
  if (request.query.pageSize) { // undefined면 자동으로 형변환한다. false면 실행하지않는다
    pageSize = parseInt(request.query.pageSize)
  }
  studentService.list(pageNO, pageSize, function(results, totalCount) {
    response.render('student/index', {data: results}) // 가져온 데이터를 index템플릿에주고 그값을 data라는 이름으로 담는다.
    //render -> handlebar로 보냄 handlebar는 데이터를 뽑아서 html로 만들어서 리턴.
  }, function(error) {
    response.end('오류!')
    throw error
  })
})

module.exports = router
