package com.salody.sldcontroller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.salody.dto.BoardAttachDTO;

/*  1. 현재날짜로 된 폴더 생성
	2. 날짜로 된 폴더에 파일 생성
	3.BoardAttach에 들어가있는 파일 저장 (for문의 set으로 되어있는 부분)
	Controller에 BoardDTO와 attlist가 저장되어 있어서 => service로 데이터 전달
*/

@Controller
@RequestMapping("/brdUpload")
public class UploadController {

	private static final Logger logger=LoggerFactory.getLogger(UploadController.class);
	
	@GetMapping("/uploadForm")
	public String getUploadform() {
		return "/board/uploadForm";
	}
	
	//-날짜별 새로운 폴더를 생성할 때, 현재날짜를 구하는 method
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();									
		String str = sdf.format(date);
    
		return str.replace("-",File.separator);
	}
	
	@PostMapping("/uploadFormAction")
	//1. 매개변수를 통해서 .jsp에서 받은 정보들을 처리 (.jsp의 name과 uploadFile이 동일함)
	//public void postUpload(MultipartFile uploadFile) {	
	
	//2. 파일 이미지 여러개를 선택할 때, 배열을 활용한다.
	//public void postUpload(MultipartFile[] uploadFile) {
	
	//**자바스크립트 - controller 연결
	public ResponseEntity<ArrayList<BoardAttachDTO>> postUpload(MultipartFile[] uploadFile) {
		System.out.println("uploadFormAction");
		
		ArrayList<BoardAttachDTO> attlist = new ArrayList<>();
		String uploadFolder="D:\\uploadFolder";
		String uploadFolderPath=getFolder();
					
				if(uploadPath.exists()==false) {
					uploadPath.mkdirs();
			}
			System.out.println("file="+uploadFile.length);
			for(MultipartFile files : uploadFile) {
				logger.info("사용자가 선택한 파일명 = " + files.getOriginalFilename());
				logger.info("사용자가 선택한 파일크기 = " + files.getSize());
				
				BoardAttachDTO attach = new BoardAttachDTO();
				String uploadFileName = files.getOriginalFilename();
				
				attach.setFileName(uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			logger.info("uuid="+uuid);
			uploadFileName=uuid.toString()+"_"+files.getOriginalFilename();	
			
			try {
				File saveFile = new File(uploadPath,uploadFileName);
				logger.info("saveFile="+saveFile);
				files.transferTo(saveFile);
				attach.setUploadPath(uploadFolderPath);
				attach.setUuid(uuid.toString());
				
				attlist.add(attach);
				logger.info("attlist="+attlist);
			}catch(Exception e) {
				e.getMessage();
			}
			
			}//for문끝
      
			return new ResponseEntity<>(attlist,HttpStatus.OK);
	}//uploadFormAction 끝
	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFiles(String fileName){
		File file = new File("D:\\uploadFolder\\"+fileName);
		ResponseEntity<byte[]> result=null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),
					header, HttpStatus.OK);
		}catch(IOException e) {
			e.printStackTrace();
		}
			return result;
		
	}
		
}

	
