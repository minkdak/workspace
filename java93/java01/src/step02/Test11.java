/* 변수 선언: 배열 응용 - 학생성적 데이터 보관*/
package step02;

public class Test11 {

  public static void main(String[] args) {
    String[] names = {"홍길동", "임꺽정", "유관순"};
    byte[][] scores = {{100, 99, 100}, {90, 91, 90}, {80, 80, 80}};
    short[] totals = {300, 270, 240};
    float[] aver = {100f, 90f, 80.0f};
    
    
    for(int i = 0; i < names.length; i++) {
    System.out.printf("이름: %s, 국어: %d, 영어: %d, 수학: %d, 총점: %d, 평균: %.1f\n", 
      names[i], scores[i][0], scores[i][1], scores[i][2], totals[i], aver[i]);
    }
 }
}
//