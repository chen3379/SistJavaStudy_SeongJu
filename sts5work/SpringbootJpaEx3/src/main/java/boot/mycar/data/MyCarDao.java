package boot.mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyCarDao {

	@Autowired
	MyCarDaoInter carInter;
	
	//insert
	public void insertMyCar(MyCarDto dto) {
		
		carInter.save(dto); //id 타입의 유무에 따라서 자동으로 insert or update 를 구분해서 처리
	}
	
	//select
	public List<MyCarDto> getAllDatas() {
		
		return carInter.findAll();
	}
	
	//update
	//num에 대한 하나의 dto
	public MyCarDto getData(long num) {
	
		return carInter.getById(num);
	}
	
	//update
	public void updateMyCar(MyCarDto dto) {
		
		carInter.save(dto); //num을 포함하고 있으므로 update 수정됨
	}
	
	//delete
	public void deleteMyCar(long num) {
		carInter.deleteById(num);
	}
}