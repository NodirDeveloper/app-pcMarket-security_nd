package uz.pdp.apppcmarketsecu.repository.projectionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarketsecu.entity.User;
import uz.pdp.apppcmarketsecu.projection.UserCustom;

@RepositoryRestResource(path = "user",excerptProjection = UserCustom.class)
public interface UserRepository extends JpaRepository<User,Integer> {

}
