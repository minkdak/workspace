window.$ = window.jQuery = require('jquery')
const mysql = require('mysql')
const connection = mysql.createConnection({
  database: 'webappdb',
  user: 'webapp',
  password: '1111'
})
connection.connect()

function selectListStudent(pageNo, successFn, errorFn) {
  connection.query(
  'select m.mno, m.name, m.tel, m.email, s.work \
  from stud s inner join memb m on s.sno=m.mno \
  order by m.mno asc \
  limit ?, ?',
  [(pageNo - 1 ) * 3, 3],
    function(error, results) {
      if(error) {
        errorFn(error)
      } else {
        successFn(results)
    }
  }) //connection.query()
} //selectListStudent()

function countAllStudent(successFn, errorFn) {
  connection.query(
    'select count(*) cnt from stud',
    function(error, results) {
      if (error) {
        errorFn(error)
      } else {
        successFn(results)
      }
  }) //connection.query()
} // countAllStudent()

function selectOneStudent(no, successFn, errorFn) {
  connection.query (
  'select m.mno, m.name, m.tel, m.email, s.work, s.schl_nm \
  from stud s inner join memb m on s.sno=m.mno \
  where s.sno=?',
  [no], // 받아와서 no로 맞춰준다.
  function(error, results) {
    if(error) {
     errorFn(error)
    } else {
     successFn(results[0])
    }
  })//connection.query
}//selectOneStudent()

function insertStudent(student, successFn, errorFn) {
  connection.query(
    'insert into stud(sno,work,schl_nm) values(?,?,?)',
    [student.no, student.working, student.schoolName],
    function(error, result) {
    if (error) {
      errorFn(error)
    } else {
      successFn(result)
      console.log(result)
    }}
  )//connection.query
  }// insertstud


function insertMember(member, successFn, errorFn) {
  connection.query(
    'insert into memb(name,tel,email,pwd) values(?,?,?,password(?))',
    [member.name, member.tel, member.email, member.password],
  function(error, result) {
    if(error) {
      errorFn(error)
    } else {
      successFn(result)
    }
  }) //connection.query
} //insertMemb

function updateStudent(student, successFn, errorFn) {
connection.query(
  'update stud set work=?, schl_nm=? where sno=?',
  [student.working, student.schoolName, student.no],
function(error, result) {
  if (error) {
    errorFn(error)
  } else {
    successFn(result)
  }
}) // connection.query
}//function

function updateMember(member, successFn, errorFn) {
connection.query(//'''''''''''''
  'update memb set name=?, tel=?, email=? where mno=?',
  [member.name, member.tel, member.email, member.no],
  function(error, result) {
    if (error) {
      errorFn(error)
    } else {
      successFn(result)
    }
  })//if(error)
} //updateMember()


function deleteMember(member, successFn, errorFn) {
  connection.query(
    'delete from memb where mno=?',
    [no],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  })// connection.query()}
}//deleteMember()

function deleteStudent(student, successFn, errorFn) {
  connection.query( //'''''''''''''
    'delete from stud where sno=?',
    [no],
    function(error, result) {
      if (error) {
        errorFn(error)
      } else {
        successFn(result)
      }
  })//connection.query()
} //deleteStudent()
