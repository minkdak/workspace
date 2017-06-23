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
  if (request.query.pageNo) {
    pageNo = parseInt(request.query.pageNo)
  }
  if (request.query.pageSize) {
    pageSize = parseInt(request.query.pageSize)
  }
  studentService.list(pageNo, pageSize, function(results, totalCount) {
    var lastPageNo = parseInt(totalCount / pageSize) + (((totalCount % pageSize) > 0) ? 1 : 0)

    // response.setHeader('Content-Type', 'text/html;charset=UTF-8')
    response.render('student/index', {
      data: results,
      pageNo: pageNo,
      nextPageNo: pageNo + 1,
      prevPageNo : pageNo - 1,
      'disabledPreBtn': (pageNo == 1) ? 'disabled' : '',
      'disabledNextBtn': (pageNo == lastPageNo) ? 'disabled' : ''
    })
  }, function(error) {
    response.render('error', {'mssage': '학생 목록 데이터 로딩 중 오류가 발생했습니다.'})
    throw error
  })
})
router.get('/detail.do', function(request, response) {
  var no = parseInt(request.query.no)
  studentService.detail(no, function(result) {
    response.render('student/view', {
      'data': result,
      'checkedWorking': (result.work == 'Y' ? 'checked' : '')
    })
  }, function(error) {
    response.render('error', {'mssage': '학생 데이터를 가져오는 중 오류가 발생했습니다.'})
    throw error
  })
})

router.post('/update.do', function(request, response) {
  // console.log('no=', request.body.no + '\n') //post요청으로 넘어온것은 body라는 이름으로 꺼낸다.
  // console.log('name=', request.body.name + '\n')
  // console.log('email=', request.body.email + '\n')
  // console.log('tel=', request.body.tel + '\n')
  // console.log('schoolName=', request.body.schoolName + '\n')
  // console.log('working=', request.body.working + '\n')
  // studentService.update({},function(result) {}, function(error) {})
  //렌더링 엔드를 경유하면 헤더를 지정할필요없지만, 지금은 렌더링 엔드를 경유하지않기때문에 헤드를 줘야한다
  studentService.update({}, function(result) {
    no: request.body.name,
    working: ((request.body.working == undefined) ? 'N' : 'Y'),
    schoolName: request.body.schoolName,
    name: requset.body.name,
    tel: request.body.tel,
    email: reuqest.body.email,
    password: '1111'
  } function (error) {
    // 웹 브라우저에게 응답 내용을 보내지 않고,
    // 대신 list.do로 다시 요청하라고 응답한다.
    // 그러면 웹브라우저는 list.do로 다시 요청한다.
    response.redirect('list.do')
    response.render('error', {'mssage': '학생 목록 데이터 로딩 중 오류가 발생했습니다.'})
  })
})

  // response.end('오류~!~!')
  // response.redirect('list.do')
})


module.exports = router
