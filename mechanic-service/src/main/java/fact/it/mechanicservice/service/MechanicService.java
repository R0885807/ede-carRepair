package fact.it.mechanicservice.service;

import fact.it.mechanicservice.dto.MechanicRequest;
import fact.it.mechanicservice.dto.MechanicResponse;
import fact.it.mechanicservice.model.Mechanic;
import fact.it.mechanicservice.repository.MechanicRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MechanicService {
    private final MechanicRepository mechanicRepository;

    @PostConstruct
    public void loadData(){
        if(mechanicRepository.count() <= 0){
            Mechanic mechanic = Mechanic.builder()
                    .name("John Doe")
                    .age("36")
                    .experience("5")
                    .build();

            Mechanic mechanic1 = Mechanic.builder()
                    .name("Peter De Mechanieker")
                    .age("31")
                    .experience("9")
                    .build();

            mechanicRepository.save(mechanic);
            mechanicRepository.save(mechanic1);
        }
    }

    public void createMechanic(MechanicRequest mechanicRequest){
        Mechanic mechanic = Mechanic.builder()
                .name(mechanicRequest.getName())
                .age(mechanicRequest.getAge())
                .experience(mechanicRequest.getExperience())
                .build();

        mechanicRepository.save(mechanic);
    }

    public List<MechanicResponse> getAllMechanics() {
        List<Mechanic> mechanics = mechanicRepository.findAll();

        return mechanics.stream().map(this::mapToMechanicResponse).toList();
    }

    private MechanicResponse mapToMechanicResponse(Mechanic mechanic) {
        return MechanicResponse.builder()
                .id(mechanic.getId())
                .name(mechanic.getName())
                .age(mechanic.getAge())
                .experience(mechanic.getExperience())
                .build();
    }
}

