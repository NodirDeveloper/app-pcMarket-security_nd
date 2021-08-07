package uz.pdp.apppcmarketsecu.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarketsecu.entity.Client;

@Projection( types = Client.class)
public interface ClientCustom {
    Integer getId();

    String getName();

    String getAddress();

    String getPhoneNumber();

    String getEmail();
}
