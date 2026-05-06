package sardor_777.taqdimotapi.dto;

import jakarta.persistence.Entity;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FieldDto {
    private String description;
    private String catagory;
    private Boolean isavailable;
}
