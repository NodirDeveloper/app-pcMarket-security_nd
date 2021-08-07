package uz.pdp.apppcmarketsecu.repository.projectionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarketsecu.entity.Brand;
import uz.pdp.apppcmarketsecu.projection.BrandCustom;

@RepositoryRestResource(path = "brand",excerptProjection = BrandCustom.class)
public interface BrandRepository extends JpaRepository<Brand,Integer> {


}
