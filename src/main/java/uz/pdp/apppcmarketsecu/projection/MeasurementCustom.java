package uz.pdp.apppcmarketsecu.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarketsecu.entity.Measurement;

@Projection(types = Measurement.class)
public interface MeasurementCustom {
    Integer getId();
    String getName();
}
