package fact.it.carservice.repository;

import fact.it.carservice.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, String>{
    List<Car> findBySerialNumberIn(List<String> serialNumber);
}
