package fact.it.mechanicservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MechanicResponse {
    private String id;
    private String name;
    private String age;
    private String experience;
    private boolean busy;
}
