package step21.ex5;

public abstract class Mortor {
  float ampere;// 암페어
  int rpm; // 분당 회전수
  float watt; // 와트
  
  public Mortor() {}
   
  public Mortor(float ampere, int rpm, float watt) {
    this.ampere = ampere;
    this.rpm = rpm;
    this.watt = watt;
  }
}
