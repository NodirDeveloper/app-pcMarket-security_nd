package uz.pdp.apppcmarketsecu.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private String name;

    private String email;

    private String phoneNumber;

    private Integer addressId;


}
