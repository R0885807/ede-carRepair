package fact.it.mechanicservice.repository;

import fact.it.mechanicservice.model.Mechanic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MechanicRepository extends MongoRepository<Mechanic, String> {
}

