package boot.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.MemberDto;
import boot.data.mapper.MemberMapperInter;

@Service
public class MemberService {

	@Autowired
	MemberMapperInter mapper;
	
	public void insertMember(MemberDto dto) {
		mapper.insertMember(dto);
	}
	
	public List<MemberDto> getAllMembers() {
		return mapper.getAllMembers();
	}
	
	public int getSearchId(String id) {
		return mapper.getSearchId(id);
	}
}
