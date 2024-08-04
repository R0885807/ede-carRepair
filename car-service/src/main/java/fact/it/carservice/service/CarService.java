package fact.it.carservice.service;

import fact.it.carservice.dto.CarRequest;
import fact.it.carservice.dto.CarResponse;
import fact.it.carservice.model.Car;
import fact.it.carservice.repository.CarRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    @PostConstruct
    public void loadData(){
        if(carRepository.count() <= 0){
            Car car = Car.builder()
                    .serialNumber("1HGBH41JXMN109186")
                    .brand("Toyota")
                    .model("Corolla")
                    .year("2020")
                    .build();

            Car car1 = Car.builder()
                    .serialNumber("1KDIJ41JXMN108566")
                    .brand("Toyota")
                    .model("Yaris")
                    .year("2020")
                    .build();

            carRepository.save(car);
            carRepository.save(car1);
        }
    }

    public void createCar(CarRequest carRequest){
        Car car = Car.builder()
                .serialNumber(carRequest.getSerialNumber())
                .brand(carRequest.getBrand())
                .model(carRequest.getModel())
                .year(carRequest.getYear())
                .build();

        carRepository.save(car);
    }

    public List<CarResponse> getAllCars() {
        List<Car> cars = carRepository.findAll();

        return cars.stream().map(this::mapToCarResponse).toList();
    }

    public List<CarResponse> getAllCarsBySerialNumber(List<String> serialNumber) {
        List<Car> cars = carRepository.findBySerialNumberIn(serialNumber);

        return cars.stream().map(this::mapToCarResponse).toList();
    }

    private CarResponse mapToCarResponse(Car car) {
        return CarResponse.builder()
                .id(car.getId())
                .serialNumber(car.getSerialNumber())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .build();
    }
}
