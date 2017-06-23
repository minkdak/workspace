/* 역할: memb 테이블의 값을 보관할 때 사용할 클래스
 * => 복합 데이터를 다룰 때, 이렇게 클래스를 정의하여 사용한다.
 * => 이런 복합 데이터를 보관하는 용도로 사용하는 클래스를
 *    "도메인(domain)" 클래스 또는 "DTO(Data Transfer Object)"라 부른다.
 */
package assignment;

public class Lecture {
  int no;
  int crmno;
  int mrno;
  String title;
  String description;
  String startDate;
  String endDate;
  int quantity;
  int price;
  int totalHours;
  
  @Override
  public String toString() {
    return "Lecture [no=" + no + ", title=" + title + ", description=" + description + ", startDate=" + startDate
        + ", endDate=" + endDate + ", quantity=" + quantity + ", price=" + price + ", totalHours=" + totalHours + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  
  
  public int getCrmno() {
    return crmno;
  }

  public void setCrmno(int crmno) {
    this.crmno = crmno;
  }

  public int getMrno() {
    return mrno;
  }

  public void setMrno(int mrno) {
    this.mrno = mrno;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getTotalHours() {
    return totalHours;
  }

  public void setTotalHours(int totalHours) {
    this.totalHours = totalHours;
  }
  

  
  
}
