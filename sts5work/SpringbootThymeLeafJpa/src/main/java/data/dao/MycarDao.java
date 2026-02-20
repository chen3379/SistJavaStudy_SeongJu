package data.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import data.dto.MycarDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MycarDao {

	MycarDaoInter inter;
	
	// DB 저장
	public void insertMycar(MycarDto dto) {
		inter.save(dto); // save 는 DTO에 num 값의 포함 유무에 따라 insert,update 
	}
	
	// 전체 반환
	public List<MycarDto> getAllCars() {
		
//		return inter.findAll(); // 전체 데이터 반환
		return inter.findAll(Sort.by(Sort.Direction.DESC,"carprice")); // 가격 높은 순
//		return inter.findAll(Sort.by(Sort.Direction.ASC,"carprice")); // 가격 낮은 순
	}
	
	// num 에 해당하는 DTO 반환
	public MycarDto getCar(Long num) {
		return inter.getReferenceById(num);
	}
	
	// delete
	public void deleteMyCar(Long num) {
		inter.deleteById(num);
	}
	
	// update
	public void updateMycar(MycarDto dto) {
		inter.save(dto); // num 값 포함
	}
}
