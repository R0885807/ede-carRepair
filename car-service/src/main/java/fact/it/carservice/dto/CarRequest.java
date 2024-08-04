package fact.it.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CarRequest {
    private String serialNumber;
    private String brand;
    private String model;
    private String year;
}
