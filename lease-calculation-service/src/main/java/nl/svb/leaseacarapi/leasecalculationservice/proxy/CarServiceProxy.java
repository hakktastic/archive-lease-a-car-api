package nl.svb.leaseacarapi.leasecalculationservice.proxy;

import java.util.Optional;
import nl.svb.leaseacarapi.leasecalculationservice.bean.CarBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Proxy for retrieving Car Entities from Car-Service through Feign.
 *
 * @author HAKKI CABUK
 *
 */
@FeignClient(name = "car-service", url = "http://localhost:8082")
public interface CarServiceProxy {

  /**
   * Get Car object.
   *
   * @param id Id of the Car object
   * @return Returns a {@link CarBean} object containing car data
   */
  @GetMapping("/cars/{id}")
  Optional<CarBean> getCarById(@PathVariable int id);
}
