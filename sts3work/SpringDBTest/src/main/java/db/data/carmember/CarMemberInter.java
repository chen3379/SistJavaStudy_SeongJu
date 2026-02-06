package db.data.carmember;

import java.util.List;

public interface CarMemberInter {

	
	public void insertCarmember(CarMemberDto dto);
	public List<CarMemberDto> getAllMembers();
	public void deleteMember(int num);
	public void updateMember(CarMemberDto dto);
	public CarMemberDto selectCarMember(int num);
}
