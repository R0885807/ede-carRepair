package fact.it.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CarResponse {
    private String id;
    private String serialNumber;
    private String brand;
    private String model;
    private String year;
}
