package uz.pdp.apppcmarketsecu.repository.projectionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarketsecu.entity.Client;
import uz.pdp.apppcmarketsecu.projection.ClientCustom;

@RepositoryRestResource(path = "client",excerptProjection = ClientCustom.class)
public interface ClientRepository extends JpaRepository<Client,Integer> {

}
