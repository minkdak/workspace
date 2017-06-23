/* 주체: 객체 - 함수를 이용하여 객체를 생성하기

 */
"use strict"

function createScore(name, kor, eng, math) {
  return {
    name: name,
    kor: kor,
    eng: eng,
    math: math,
    sum: kor + eng + math,
    aver: (kor + eng + math) / 3
  }
}

// 배열에 여러 종류의 값을 저장할 수 있다.
var score = [
  ["홍길동1", 100, 100, 100, 300, 100],
  ["홍길동2", 90, 90, 90, 270, 90],
  ["홍길동3", 80, 80, 80, 240, 80],
  ["홍길동4", 70, 70, 70, 210, 70],
  ["홍길동5", 60, 60, 60, 240, 60]
]
console.log("홍길동3의 총점은?", score[2][4])
console.log('------------------')

var scroes2 = [
  createScore("홍길동1", 100, 100, 100),
  createScore("홍길동2", 90, 90, 90),
  createScore("홍길동3", 80, 80, 80),
  createScore("홍길동4", 70, 70, 70),
  createScore("홍길동5", 60, 60, 60),
]//함수저장 아니라 함수의 리턴 값 저장



console.log("홍길동3의 총점은?", scores2[2].sum)
