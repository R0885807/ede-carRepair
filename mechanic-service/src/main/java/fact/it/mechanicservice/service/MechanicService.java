package fact.it.mechanicservice.service;

import fact.it.mechanicservice.dto.MechanicRequest;
import fact.it.mechanicservice.dto.MechanicResponse;
import fact.it.mechanicservice.model.Mechanic;
import fact.it.mechanicservice.repository.MechanicRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.el.parser.AstFalse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MechanicService {
    private final MechanicRepository mechanicRepository;

    @PostConstruct
    public void loadData(){
        if(mechanicRepository.count() <= 0){
            Mechanic mechanic = new Mechanic();
            mechanic.setName("John Doe");
            mechanic.setAge("25");
            mechanic.setExperience("5");
            mechanic.setBusy(false);

            Mechanic mechanic1 = new Mechanic();
            mechanic.setName("Peter De Mechanieker");
            mechanic.setAge("31");
            mechanic.setExperience("9");
            mechanic.setBusy(false);


            mechanicRepository.save(mechanic);
            mechanicRepository.save(mechanic1);
        }
    }



    public void createMechanic(MechanicRequest mechanicRequest){
        Mechanic mechanic = new Mechanic();
                mechanic.setName(mechanicRequest.getName());
                mechanic.setAge(mechanicRequest.getAge());
                mechanic.setExperience(mechanicRequest.getExperience());
                mechanic.setBusy(mechanicRequest.isBusy());


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
                .busy(mechanic.isBusy())
                .build();
    }
}

