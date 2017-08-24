package travelstudio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travelstudio.dao.PictureDao;
import travelstudio.domain.Picture;
import travelstudio.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {
  @Autowired PictureDao pictureDao;
  
public void add(String filename) throws Exception {
  pictureDao.insert2(filename);
  
}  
 
public void add1(Picture picture) throws Exception {
  pictureDao.insert1(picture);
  
}

public void addAllPicture(Picture picture) throws Exception {
  pictureDao.insertAllPhoto(picture);
  
}

 public void add(Picture picture) throws Exception {
   pictureDao.insert(picture);
   
 }
 
 public List<Picture> selectPicNo(String path){
   return pictureDao.selectPicNo(path);
   
 };
 @Override
 public Picture selectByPost(String pictureno) {
     return pictureDao.selectByPost(pictureno);
     
 };

 public Picture searchthispicture(String path) {
   return pictureDao.searchthispicture(path);
   
 };
 public Picture searchPicNo(String path) {
   System.out.printf("나오냐====>");
   System.out.println(path);
   return pictureDao.searchPicNo(path);
 };
 
 public void delete(int deletepno) {
   System.out.println("임플에서 path 출력");
   System.out.println(deletepno);
   pictureDao.delete(deletepno);
 }
 
//public void delete(String path) {
//  System.out.println("임플에서 path 출력");
//  System.out.println(path);
//  pictureDao.delete(path);
//}
//  
//  public Teacher get(int no) throws Exception {
//    return teacherDao.selectOne(no);
//  }
//  
//  public Teacher getByEmailPassword(String email, String password) throws Exception {
//    HashMap<String,Object> valueMap = new HashMap<>();
//    valueMap.put("email", email);
//    valueMap.put("password", password);
//    
//    return teacherDao.selectOneByEmailPassword(valueMap);
//  }
  
//  @Override
//  public int getSize() throws Exception {
//    return noticeDao.countAll();
//  }
  
//  // XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
//  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
//  public void add(Teacher teacher) throws Exception {
//    memberDao.insert(teacher);
//    teacherDao.insert(teacher);
//    this.insertPhoto(teacher.getNo(), teacher.getPhotoList()); // 강사 사진 추가
//  }
//  
//  //XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
//  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
//  public void update(Teacher teacher) throws Exception {
//    int count = memberDao.update(teacher);
//    if (count < 1) {
//      throw new Exception(teacher.getNo() + "번 강사를 찾을 수 없습니다.");
//    }
//    
//    count = teacherDao.update(teacher);
//    if (count < 1) {
//      throw new Exception(teacher.getNo() + "번 강사를 찾을 수 없습니다.");
//    }
//    
//    // 강사 사진 갱신
//    teacherDao.deletePhoto(teacher.getNo()); // 강사의 모든 사진을 지운다.
//    this.insertPhoto(teacher.getNo(), teacher.getPhotoList()); // 강사 사진 추가
//  }
//  
//  private void insertPhoto(int teacherNo, List<String> photoPathList) {
//    if (photoPathList == null)
//      return;
//    
//    HashMap<String,Object> valueMap = new HashMap<>();
//    valueMap.put("teacherNo", teacherNo);
//    
//    for (String photoPath : photoPathList) {
//      valueMap.put("photoPath", photoPath);
//      teacherDao.insertPhoto(valueMap);
//    }
//  }
//  
//  //XML 태그로 트랜잭션을 설정하게 되면 @Transactional 애노테이션은 필요없다.
//  //@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
//  public void remove(int no) throws Exception {
//    teacherDao.deletePhoto(no);
//    int count = teacherDao.delete(no);
//    if (count < 1) {
//      throw new Exception(no + "번 강사를 찾을 수 없습니다.");
//    }
//    
//    try {
//      count = memberDao.delete(no);
//    } catch (Exception e) {}
//  }
}







