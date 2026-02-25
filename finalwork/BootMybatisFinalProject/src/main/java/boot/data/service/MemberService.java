package boot.data.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import boot.data.dto.MemberDto;
import boot.data.mapper.MemberMapperInter;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberService {

	@Autowired
	MemberMapperInter mapper;
	
	public void insertMember(MemberDto dto,HttpSession session,MultipartFile myphoto) {
		
		//톰캣경로
		String path=session.getServletContext().getRealPath("/membersave");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName=sdf.format(new Date())+myphoto.getOriginalFilename();
		
		dto.setPhoto(fileName);
		
		//upload
		try {
			myphoto.transferTo(new File(path+"\\"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mapper.insertMember(dto);
	}
	
	public List<MemberDto> getAllMembers() {
		return mapper.getAllMembers();
	}
	
	public int getSearchId(String id) {
		return mapper.getSearchId(id);
	}
	
	public MemberDto getMember(String num) {
		return mapper.getMember(num);
		
	}
	
	public void deleteMember(String num) {
		mapper.deleteMember(num);
	}
	
	public void updatePhoto(String num,String photo) {
		Map<String, String> map=new HashMap<>();
		map.put("num", num);
		map.put("photo", photo);
		mapper.updatePhoto(map);
	}
	
	public void updateMember(MemberDto dto) {
		mapper.updateMember(dto);
	}
	
	public String getName(String id) {
		return mapper.getName(id);
	};
	
	public int loginCheck(String id,String pass) {
		Map<String, String> map= new HashMap<>();
		map.put("id", id);
		map.put("pass", pass);
		return mapper.loginCheck(map);
	};

	public MemberDto getDataById(String id) {
		return mapper.getDataById(id);
	};
	
}
