package uz.pdp.apppcmarketsecu.repository.projectionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarketsecu.entity.Measurement;
import uz.pdp.apppcmarketsecu.projection.MeasurementCustom;

@RepositoryRestResource(path = "measurement",excerptProjection = MeasurementCustom.class)
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {

}
