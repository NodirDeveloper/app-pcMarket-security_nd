package uz.pdp.apppcmarketsecu.projection;

import uz.pdp.apppcmarketsecu.entity.Brand;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Brand.class)
public interface BrandCustom {
    Integer getId();
    String getName();


}
