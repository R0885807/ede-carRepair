package fact.it.mechanicservice.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MechanicRequest {
    private String name;
    private String age;
    private String experience;
}
