package travelstudio.control.json;




import java.io.File;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import travelstudio.domain.Detail;
import travelstudio.domain.Member;
import travelstudio.domain.Post;
import travelstudio.service.DetailService;
import travelstudio.service.PostService;




@RestController
@RequestMapping("/post/")
public class PostControl {
  
  @Autowired ServletContext ctx;
  @Autowired PostService postService;
  @Autowired DetailService detailService;
  
  @RequestMapping("list")
  public JsonResult list() throws Exception {
    
    
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", postService.list());
//    dataMap.put("totalCount", noticeService.getSize());
    
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("selectOneUserPost")
  public JsonResult selectOneUserPost(int number) throws Exception {
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("selectOneUserPost", postService.selectOneUserPost(number));
//    dataMap.put("totalCount", noticeService.getSize());
    
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  
  @RequestMapping("count")
  
  public JsonResult getWriteCount(Post post) throws Exception {
    System.out.println(post);
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("list", postService.getWriteCount(post));
    
    
    return new JsonResult(JsonResult.SUCCESS,dataMap);
  }
  
  @RequestMapping("add")
  public JsonResult add(Post post, String[] content, HttpServletRequest req, MultipartFile[] files) throws Exception {
    HttpServletRequest httpRequest= (HttpServletRequest) req;
    Member loginMember = (Member)httpRequest.getSession().getAttribute("loginMember");
    /*System.out.println(files[0]);*/
    String newFilename = this.getNewFilename();
    File file = new File(ctx.getRealPath("/upload/" + newFilename));
    
    
    System.out.println(post);
    
    if(files!=null){
    files[0].transferTo(file);
    post.setCont("/upload/" + newFilename);
    }
    
    post.setNo(loginMember.getNo());
    postService.add(post);
    
    File thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_1920"));
//    Thumbnails.of(file).size(1920, 1400).outputFormat("png").toFile(thumbnail);
    
    /*System.out.println(post.getCont());*/
    /*System.out.println(post);
     * 
    System.out.println(post.getPostno());*/
    
    Detail detail = new Detail();
    
    detail.setPostno(post.getPostno());
    /*System.out.println(post.getCont());*/
    
    detail.setWriter(loginMember.getEmail());
    
    System.out.println(content);
    for(int i=0;i<content.length;i++){
      detail.setCont(content[i]);
      detailService.insertDetailContent(detail);
    }
    
    
    detailService.insertDetailByEmail(detail);
    detailService.deleteEmail(loginMember.getEmail());
    return new JsonResult(JsonResult.SUCCESS, post);
  }  
  
  @RequestMapping("info1")
  public JsonResult info1(String number) throws Exception {
    System.out.println(number);
    HashMap<String,Object> dataMap = new HashMap<>();
    dataMap.put("info", postService.info1(number));
    return new JsonResult(JsonResult.SUCCESS, dataMap);
  }
  

  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }
  
}









