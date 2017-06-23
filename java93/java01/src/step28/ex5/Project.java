package step28.ex5;

import java.sql.Date;
import java.util.List;

public class Project {
  int no;
  String title;
  String content;
  Date startDate;
  Date endDate;
  String photoPath;
  List<Member> members; 
  /* 이건 테이블에 없음. Project와 Member의 (Aggregation) 관계를 포함한거다.
   * 이렇게 하면 쿼리 두 번 날릴 것을 한 번으로 줄일 수 있다.
   */
  
  
  @Override
  public String toString() {
    return "Project [no=" + no + ", title=" + title + ", content=" + content + ", startDate=" + startDate + ", endDate="
        + endDate + ", photoPath=" + photoPath + ", members=" + members + "]";
  }
  
  public int getNo() {
    return no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public Date getStartDate() {
    return startDate;
  }
  
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  
  public Date getEndDate() {
    return endDate;
  }
  
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  
  public String getPhotoPath() {
    return photoPath;
  }
  
  public void setPhotoPath(String photoPath) {
    this.photoPath = photoPath;
  }
  
  public List<Member> getMembers() {
    return members;
  }
  
  public void setMembers(List<Member> members) {
    this.members = members;
  }
  
  
  
}
