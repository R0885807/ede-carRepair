package fact.it.carservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "car")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Car {
    private String id;
    private String serialNumber;
    private String brand;
    private String model;
    private String year;
}
