package step27.ex3;

import java.sql.Date;

import org.springframework.beans.factory.FactoryBean;

public class TireFactoryBean implements FactoryBean {
  String maker;
  float inch;
  Date createdDate;
  
  public TireFactoryBean() {}
  public TireFactoryBean(String maker, int inch) {
    this.maker = maker;
    this.inch = inch;
  }
  @Override
  public String toString() {
    return "Tire [maker=" + maker + ", inch=" + inch + ", createdDate=" + createdDate + "]";
  }
  
  
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public float getInch() {
    return inch;
  }
  public void setInch(float inch) {
    this.inch = inch;
  }
  
  @Override
  public Object getObject() throws Exception {
    createdDate = Date.valueOf("2017-06-21");
    return null;
  }
  @Override
  public Class getObjectType() {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public boolean isSingleton() {
    // TODO Auto-generated method stub
    return false;
  }
  
}
