package uz.pdp.apppcmarketsecu.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto {
    private Date date;

    private Set<Integer> productSet;

    private Set<Integer> clientSet;

    private boolean active;

}
