package nl.svb.leaseacarapi.leasecalculationservice.proxy;

import java.util.Optional;
import nl.svb.leaseacarapi.leasecalculationservice.bean.CustomerBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Proxy for retrieving Customer Entities from Customer-Service through Feign.
 *
 * @author HAKKI CABUK
 *
 */
@FeignClient(name = "customer-service", url = "http://localhost:8081")
public interface CustomerServiceProxy {

  /**
   * Get Customer Entity by ID.
   *
   * @param id ID of Customer Entity
   * @return Returns a {@link CustomerBean} object
   */
  @GetMapping("/customers/{id}")
  Optional<CustomerBean> getCustomerById(@PathVariable int id);

}
