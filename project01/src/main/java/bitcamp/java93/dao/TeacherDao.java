package bitcamp.java93.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import bitcamp.java93.domain.Teacher;

@Component
public interface TeacherDao {
  
  List<Teacher> selectList(Map<String,Object> valueMap);
  List<String> selectPhotoList(Map<String,Object> valueMap); 
  Teacher selectOne(int no) throws Exception ;
  
  Teacher selectOneByEmailPassword(Map<String,Object> valueMap);  
  int insert(Teacher teacher);
  
  void insertPhoto(Map<String,Object> valueMap); 
  
  int delete(int no);
  
  int update(Teacher teacher);  
  void deletePhoto(int teacherNo);  
}