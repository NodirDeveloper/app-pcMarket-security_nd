package uz.pdp.apppcmarketsecu.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarketsecu.entity.User;

@Projection(types = User.class)
public interface UserCustom {
    Integer getId();

    String getFullName();

    String getEmail();

    String getPhoneNumber();

    String getPassword();

    String getRoleName();
}
