package bitcamp.java93.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.dao.TeacherDao;
import bitcamp.java93.domain.Teacher;
import bitcamp.java93.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
  @Autowired
  MemberDao memberDao;
  @Autowired
  TeacherDao teacherDao;
  
  public List<Teacher> list(int pageNo, int pageSize) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    return teacherDao.selectList(valueMap);
  }
  
  public Teacher get(int no) throws Exception {
    return teacherDao.selectOne(no);
  }
  
  public Teacher getByEmailPassword(String email, String password) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("email", email);
    valueMap.put("password", password);
    
    return teacherDao.selectOneByEmailPassword(valueMap);
  }
  
  @Override
  public int getSize() throws Exception {
    return teacherDao.countAll();
  }
  @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
  public void add(Teacher teacher) throws Exception {
    memberDao.insert(teacher);
    teacherDao.insert(teacher);
    
    this.insertPhoto(teacher.getNo(), teacher.getPhotoList());
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("teacherNo", teacher.getNo());
  }
  
  @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
  public void update(Teacher teacher) throws Exception {
    int count = memberDao.update(teacher);
    if(count < 1) throw new Exception(teacher.getNo() + "번 회원을 찾을 수 없습니다.");
    
    count = teacherDao.update(teacher);
    if(count < 1) throw new Exception(teacher.getNo() + "번 강사을 찾을 수 없습니다.");
    
    teacherDao.deletePhoto(teacher.getNo());
    this.insertPhoto(teacher.getNo(), teacher.getPhotoList());
  }
  
  @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
  public void remove(int no) throws Exception {
    teacherDao.deletePhoto(no);

    int count = teacherDao.delete(no);
    if(count < 1) throw new Exception( no + "번 강사를 찾을 수 없습니다.");
    
    try {
      count = memberDao.delete(no);
    } catch (Exception e) {}
  }
  
  public void insertPhoto(int teacherNo, List<String> photoPathList) {
    if (photoPathList == null) 
      return;
    
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("teacherNo", teacherNo);
    
    for (String photoPath : photoPathList) {
      valueMap.put("photoPath", photoPath);
      teacherDao.insertPhoto(valueMap);
    }
  }
}