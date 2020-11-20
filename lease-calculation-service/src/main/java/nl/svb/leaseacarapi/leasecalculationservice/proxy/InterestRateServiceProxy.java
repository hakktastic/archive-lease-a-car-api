package nl.svb.leaseacarapi.leasecalculationservice.proxy;

import java.util.Optional;
import nl.svb.leaseacarapi.leasecalculationservice.bean.InterestRateBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Proxy for retrieving Interest Rate Entities from Interest-Rate-Calculation-Service through Feign.
 *
 * @author HAKKI CABUK
 *
 */
@FeignClient(name = "interest-rate-calculation-service", url = "http://localhost:8083")
public interface InterestRateServiceProxy {

  /**
   * Get Interest object based on the ID.
   *
   * @param id ID of the Interest Object
   * @return Returns a {@link InterestRateBean} containing interest rate data
   */
  @GetMapping("/interestrates/{id}")
  Optional<InterestRateBean> getInterestById(@PathVariable int id);

}
