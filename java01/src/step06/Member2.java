package step06;

/* 변수에서 static을 떼어낸다.
 * 
 */
class Member2 {
  // 다음과 같이 static이 붙지 않은 변수를 "인스턴스 변수"라 부른다.
  // 왜? new 명령을 통해 인스턴스를 만들 때 비로소 생성되는 변수라는 뜻이다.
  String name;
  int[] scores = new int[3];
  int total;
  float aver;
  
  // static이 붙지 않은 변수는 메서드에 직접 사용할 수 없다.
  // 반드시 인스턴스 주소를 받아야 한다.
  public static void init(Member2 m,String name, int kor, int eng, int math) {
   m.name = name;
   m.scores[0] = kor;
   m.scores[1] = eng;
   m.scores[2] = math;
  }
  
  // 합계와 총점을 계산하는 기능의 코드를 compute() 블록안에 묶어 두었다.
  public static void compute(Member2 m) {
    m.total = m.scores[0] + m.scores[1] + m.scores[2];
    m.aver = m. total /3f;
  }
  
  // 성적 정보를 출력하는 기능을 수행하는 기능을 수행하는 코드를 print() 블록 안에 묶어 두었다.
  public static void print(Member2 m) {
    System.out.println("******************************");
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        m.name, m.scores[0], m.scores[1], m.scores[2], m.total, m.aver);
    System.out.println("******************************");
  }
}