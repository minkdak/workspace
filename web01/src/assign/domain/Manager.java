package assign.domain;

public class Manager {
  int no;
  String posi;
  String fax;
  String path;
  String name;
  
  @Override
  public String toString() {
    return "Manager [no=" + no + ", name=" + name + " posi=" + posi + ", fax=" + fax + ", path=" + path + " ]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getPosi() {
    return posi;
  }

  public void setPosi(String posi) {
    this.posi = posi;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}



  
  
