/* 문장: 조건문 if ~ else - break 사용*/
package step04;

public class Test02_3 {
  enum Level {
    GUEST, MEMBER, ADMIN;
  }   
  public static void main(String[] args) {
    // enum 문법: 상수 값을 그룹 묶어 쉽게 선언하는 방법!

    
    byte b = 10;
    short s = 10;
    int i = 10;
    long l = 10;
    float f = 10.f;
    double d = 10.0;
    boolean bool = true;
    char c = '가';
    String str = "오호라";
    
    // 4바이트 크기의 정수 값 가능!
    switch (b) {}
    switch (s) {}
    switch (i) {}
    // switch (l) {} // 8바이트 크기의 정수값 안됨. 컴파일 오류!
    switch (b) {} // char는 0 ~ 65535까지의 값을 갖는 정수형이다.
    // switch (f) {} // float 부동소수점 안됨. 컴파일 오류!
    // switch (d) {} // double 부동소수점 안됨. 컴파일 오류!
    // switch (bool) {} //boolean 값 안됨. 컴파일 오류!
    // 문자열 (java 1.7부터 가능)
    switch(str) {}
    
    // enum 타입(enumeration, 열거형) 가능 => 결국 4바이트 정수 값이다.
    switch (Level.GUEST) {}
  }
}
