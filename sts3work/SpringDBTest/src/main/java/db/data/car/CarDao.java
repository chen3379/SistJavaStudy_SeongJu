package db.data.car;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao implements CarDaoInter {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		if (sqlSession == null) {
			System.out.println("에러: sqlSession이 주입되지 않았습니다!");
			return 0;
		}
		return sqlSession.selectOne("totalCountOfCarInfo");

	}

	@Override
	public void insertCar(CarDto dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("db.data.car.CarDao.insertCar", dto);
	}

	@Override
	public List<CarDto> getAllList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("totalListOfCar");
	}

	@Override
	public void deleteCar(int num) {
		// TODO Auto-generated method stub
		sqlSession.delete("deleteCar", num);

	}

	@Override
	public void updateCar(CarDto dto) {
		// TODO Auto-generated method stub
		sqlSession.update("updateCar", dto);
	}

	@Override
	public CarDto selectCar(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectCar",num);
	}
}
