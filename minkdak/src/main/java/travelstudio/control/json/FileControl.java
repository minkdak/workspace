/* Spring WebMVC: JSON 콘텐츠로 응답하기 + 파일 업로드 + thumbnail 파일 생성
 * => AJAX 파일 업로드
 * 
 */
package travelstudio.control.json;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;
import com.drew.metadata.file.FileMetadataDirectory;

import net.coobird.thumbnailator.Thumbnails;
import travelstudio.domain.Member;
import travelstudio.domain.Picture;
import travelstudio.service.DetailService;
import travelstudio.service.PictureService;

@RestController
@RequestMapping("/File/") 
public class FileControl {
  
  @Autowired ServletContext ctx;
  @Autowired PictureService pictureService;
  @Autowired DetailService detailService;
  
  @RequestMapping(path="upload")
  public Object upload(MultipartFile[] files) throws Exception {
    
    ArrayList<Object> fileList = new ArrayList<>();
    
    for (int i = 0; i < files.length; i++) {
      if (files[i].isEmpty()) 
        continue;
      
      String newFilename = this.getNewFilename();
      File file = new File(ctx.getRealPath("/upload/" + newFilename));
      System.out.println(file);
//      System.out.println();
      files[i].transferTo(file);
      
      File thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_80"));
      Thumbnails.of(file).size(80, 80).outputFormat("png").toFile(thumbnail); 

      thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_140"));
      Thumbnails.of(file).size(140, 140).outputFormat("png").toFile(thumbnail);
      
      thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_200"));
      Thumbnails.of(file).size(200, 200).outputFormat("png").toFile(thumbnail);
        
      HashMap<String,Object> fileMap = new HashMap<>();
      fileMap.put("filename", newFilename);
      fileMap.put("filesize", files[i].getSize());
      fileList.add(fileMap);
    }
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("fileList", fileList);
    return resultMap;
  }
  


  
  @RequestMapping(path="upload3")
  public Object upload3(MultipartFile[] files, HttpServletRequest req) throws Exception {
    HttpServletRequest httpRequest= (HttpServletRequest) req;
    Member loginMember = (Member)httpRequest.getSession().getAttribute("loginMember");
    ArrayList<Object> fileList = new ArrayList<>();
    ArrayList<Picture> sortList = new ArrayList<>();
//    System.out.println(files.length);
    for (int i = 0; i < files.length; i++) {
//      File fileMetadata= files[i];
      if (files[i].isEmpty()) 
        continue;
    
      String newFilename = this.getNewFilename();
      File file = new File(ctx.getRealPath("/upload/" + newFilename));
      files[i].transferTo(file);
      
      File thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_200"));
      Thumbnails.of(file).size(200, 200).outputFormat("png").toFile(thumbnail);
      
      thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_300"));
      Thumbnails.of(file).size(300, 300).outputFormat("png").toFile(thumbnail);
      
      thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_400"));
      Thumbnails.of(file).size(400, 400).outputFormat("png").toFile(thumbnail);
      
      thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_500"));
      Thumbnails.of(file).size(500, 500).outputFormat("png").toFile(thumbnail);
      
      thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_600"));
      Thumbnails.of(file).size(600, 600).outputFormat("png").toFile(thumbnail);
      
//      System.out.println(file);
      
      Picture picture = new Picture();
      Metadata metadata = ImageMetadataReader.readMetadata(file);
      picture.setPath("/upload/" + newFilename);
      
      
      GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
      ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
      FileMetadataDirectory fileDirectory = metadata.getFirstDirectoryOfType(FileMetadataDirectory.class);
//      System.out.println(metadata.getFirstDirectoryOfType(FileMetadataDirectory.class) + "뭔데");
      if (gpsDirectory != null) {
//        System.out.println(gpsDirectory.getGeoLocation());
        picture.setLati(gpsDirectory.getGeoLocation().getLatitude());
        picture.setLongit(gpsDirectory.getGeoLocation().getLongitude());
      } else {
        picture.setLati(null);
        picture.setLongit(null);
      }
      
      Date date = null;
      
      if (directory == null) {
        date = fileDirectory.getDate(FileMetadataDirectory.TAG_FILE_MODIFIED_DATE);
      } else {
//       찍은 날짜가 있는 경우
        date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
        
        if ( date != null) {
  //        date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
//          System.out.println(date);
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
          String metaDateTime = sdf.format(date);
//          System.out.println(metaDateTime);
          picture.setTime(metaDateTime);
          
        } else if(directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL) == null) {
          if (directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_DIGITIZED) != null) {
            date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_DIGITIZED);       
          } else {
            date = fileDirectory.getDate(FileMetadataDirectory.TAG_FILE_MODIFIED_DATE);
          }
        } 
      }
      
      System.out.println(date);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String metaDateTime = sdf.format(date);
//      System.out.println(metaDateTime);
      picture.setTime(metaDateTime);
      
      sortList.add(picture);
//      pictureService.add(picture);
      
      /*
 List<Picture> picNoList = pictureService.selectPicNo("/upload/" + newFilename);
      
      Detail detail = new Detail();
      detail.setPicno(picNoList.get(0).getPicno());
      detail.setWriter(loginMember.getEmail());
      detailService.sadd(detail);
//      System.out.println(loginMember.getEmail());
      
      File thumbnail = new File(ctx.getRealPath("/upload/" + newFilename + "_700"));
      Thumbnails.of(file).size(761, 506).outputFormat("png").toFile(thumbnail); 

     
        
      HashMap<String,Object> fileMap = new HashMap<>();
      fileMap.put("filename", newFilename);
      fileMap.put("filesize", files[i].getSize());
      fileList.add(fileMap);*/
    }
    
    // 날짜순 정렬
    AscendingObj ascending = new AscendingObj();
    
    Collections.sort(sortList, ascending);
    
    int sortno=0;
    sortList.get(0).setSortno(sortno);
    pictureService.add(sortList.get(0));
    
    
    for (int i=1;i < sortList.size(); i++) {
//      System.out.println(sortList.get(i));
      if ((sortList.get(i-1).getTime()).equals(sortList.get(i).getTime())) {
        if ((sortList.get(i-1).getLati())==null && (sortList.get(i-1).getLongit())==null &&
            (sortList.get(i).getLati())==null && (sortList.get(i).getLongit())==null){
        sortList.get(i).setSortno(sortno);
        pictureService.add(sortList.get(i));
        System.out.println(sortList.get(i).getLati());
        System.out.println(sortList.get(i).getLongit());
        } else {}
      }else{
        sortno+=1;
        sortList.get(i).setSortno(sortno);
        pictureService.add(sortList.get(i));
        System.out.println(sortList.get(i));
      }
    }
    
    System.out.print("Point 오름차순 - ");
    for (Picture p : sortList) {
        System.out.print(p);
    }


    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("fileList", fileList);
    return sortList;
  }


  

  
  int count = 0;
  synchronized private String getNewFilename() {
    if (count > 100) {
      count = 0;
    }
    return String.format("%d_%d", System.currentTimeMillis(), ++count); 
  }
  
  
  class AscendingObj implements Comparator<Picture> {
    @Override
    public int compare(Picture p1, Picture p2) {
      return p1.getTime().compareTo(p2.getTime());
    }

  }


}

