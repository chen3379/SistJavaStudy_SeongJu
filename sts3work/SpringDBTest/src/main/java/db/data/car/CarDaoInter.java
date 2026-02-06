package db.data.car;

import java.util.List;

public interface CarDaoInter {

	public int getTotalCount();
	public void insertCar(CarDto dto);
	public List<CarDto> getAllList();
	public void deleteCar(int num);
	public void updateCar(CarDto dto);
	public CarDto selectCar(int num);
}
