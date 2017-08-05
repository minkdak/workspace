package step06;

/* 변수에서 static을 떼어낸다.
 * 
 */
class Member3 {
  // 다음과 같이 static이 붙지 않은 변수를 "인스턴스 변수"라 부른다.
  // 왜? new 명령을 통해 인스턴스를 만들 때 비로소 생성되는 변수라는 뜻이다.
  String name;
  int[] scores = new int[3];
  int total;
  float aver;

  // 메서드 앞에 static을 떼어내는 순간,
  // 이 메서드는 인스턴스 주소로만 호출할 수 있다.
  // 인스턴스 주소 없이는 호출할 수 없다.
  // 그리고 그 인스턴스 주소도 메서드를 호출할 때 다음과 같이 메서드 앞에 주어야 한다.
  // => 인스턴스주소.메서드명();
  // 메서드를 호출할 때 넘겨준 인스턴스 주소는
  // 내부에 미리 장착되어 있는 this라는 변수에 보관된다.
  // 물론 static이 붙은 메서드에는 this라는 변수가 없다.
  public void init(String name, int kor, int eng, int math) {
   this.name = name;
   this.scores[0] = kor;
   this.scores[1] = eng;
   this.scores[2] = math;
  }
  
  // 합계와 총점을 계산하는 기능의 코드를 compute() 블록안에 묶어 두었다.
  public void compute() {
    this.total = this.scores[0] + this.scores[1] + this.scores[2];
    this.aver = this. total /3f;
  }
  
  // 성적 정보를 출력하는 기능을 수행하는 기능을 수행하는 코드를 print() 블록 안에 묶어 두었다.
  public void print() {
    System.out.println("******************************");
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        this.name, this.scores[0], this.scores[1], this.scores[2], this.total, this.aver);
    System.out.println("******************************");
  }
}