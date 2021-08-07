package uz.pdp.apppcmarketsecu.repository.projectionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarketsecu.entity.Address;
import uz.pdp.apppcmarketsecu.projection.AddressCustom;

@RepositoryRestResource(path = "address",excerptProjection = AddressCustom.class)
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
