package sardor_777.taqdimotapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String title;
    private String price;
    private String stock;
    private String imageurl;
    private Long catagoryid;
    private String description;
    private String unut;
}
