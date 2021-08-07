package uz.pdp.apppcmarketsecu.projection;

import uz.pdp.apppcmarketsecu.entity.Address;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Address.class)
public interface AddressCustom {
    Integer getId();

    String getStreet();

    String getHomeNumber();

    String getRegion();
}
