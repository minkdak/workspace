/* 미니 Express 만들기
*/

module.exports = function() { //exports 함수객체를 호출하면 객체를 리턴한다.
  return {
    get() {
      console.log('get()...')
    },
    post() {
      console.log('post()...')
    }
  }
}
