package step06;

  class prac1 {
       String name;
       int age;
      
      public static void init(prac1 p, String n, int a) {
        p.name = n;
        p.age = a;
      }
      
      public static void print(prac1 p) {
        System.out.printf("%s %d", p.name, p.age);
      }
  }