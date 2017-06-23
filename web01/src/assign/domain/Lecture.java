package assign.domain;

public class Lecture {
  int no;
  int mrno;
  int crmno;
  String title;
  String sdt;
  String edt;
  int thrs;
  int pric;
  String dscp;
  int qty;
  
  @Override
  public String toString() {
    return "Lecture [no=" + no + ", mrno=" + mrno + ", crmno=" + crmno + ", title=" + title + ", sdt=" + sdt + ", edt="
        + edt + ", thrs=" + thrs + ", pric=" + pric + ", dscp=" + dscp + ", qty=" + qty + "]";
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
  public String getSdt() {
    return sdt;
  }
  public void setSdt(String sdt) {
    this.sdt = sdt;
  }
  public String getEdt() {
    return edt;
  }
  public void setEdt(String edt) {
    this.edt = edt;
  }
  public int getThrs() {
    return thrs;
  }
  public void setThrs(int thrs) {
    this.thrs = thrs;
  }
  public int getPric() {
    return pric;
  }
  public void setPric(int pric) {
    this.pric = pric;
  }
  public String getDscp() {
    return dscp;
  }
  
  public void setDscp(String dscp) {
    this.dscp = dscp;
  }




  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }




  public int getMrno() {
    return mrno;
  }




  public void setMrno(int mrno) {
    this.mrno = mrno;
  }




  public int getCrmno() {
    return crmno;
  }




  public void setCrmno(int crmno) {
    this.crmno = crmno;
  }
  
  
  
}
