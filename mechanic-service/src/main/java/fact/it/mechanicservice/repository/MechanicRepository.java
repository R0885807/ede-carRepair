package fact.it.mechanicservice.repository;

import fact.it.mechanicservice.model.Mechanic;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public interface MechanicRepository extends JpaRepository<Mechanic, String> {
}

