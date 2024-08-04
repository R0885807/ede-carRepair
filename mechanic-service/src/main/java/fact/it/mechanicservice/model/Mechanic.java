package fact.it.mechanicservice.model;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Mechanic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String age;
    private String experience;
    private boolean busy;
}
