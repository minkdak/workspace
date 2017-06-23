/* 템플릿 엔진 사용하기 - 외부에서 템플릿 소스를 가져오기
=> 'fs' 모듈을 이용한다
*/

const fs = require('fs')
const path =require('path')

var templPath = path.join(__dirname, 'test05_3_template.txt')
console.log(templPath)


// 비동기 방식으로 파일을 읽는다.
// => 파일을 모두 읽으면 파라미터로 주어진 함수가 호출된다.
fs.readFile(templPath, 'utf8', (err, data) => { // function(err, data)
  if(err) throw err
  console.log(data)
}) // 비동기, 동기는 sync
// 소스파일을 읽고 템플릿을 읽어 템플릿을 적용한다.
console.log("나 일빠")
