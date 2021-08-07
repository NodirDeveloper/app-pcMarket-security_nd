package uz.pdp.apppcmarketsecu.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;

    private double incomePrice;

    private double salePrice;

    private String description;

    private Integer brandId;

    private Integer categoryId;

    private Integer attachmentId;

    private Integer measurementId;


}
