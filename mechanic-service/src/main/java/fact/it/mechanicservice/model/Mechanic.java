package fact.it.mechanicservice.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "mechanic")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Mechanic {
    private String id;
    private String name;
    private String age;
    private String experience;
}
