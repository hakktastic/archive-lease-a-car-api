package nl.svb.leaseacarapi.leasecalculationservice.controller;

import java.util.Optional;
import nl.svb.leaseacarapi.leasecalculationservice.bean.CarBean;
import nl.svb.leaseacarapi.leasecalculationservice.bean.CustomerBean;
import nl.svb.leaseacarapi.leasecalculationservice.bean.InterestRateBean;
import nl.svb.leaseacarapi.leasecalculationservice.bean.LeaseRateCalculation;
import nl.svb.leaseacarapi.leasecalculationservice.proxy.CarServiceProxy;
import nl.svb.leaseacarapi.leasecalculationservice.proxy.CustomerServiceProxy;
import nl.svb.leaseacarapi.leasecalculationservice.proxy.InterestRateServiceProxy;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Lease Calculation Service.
 *
 * @author HAKKI CABUK
 *
 */
@RestController
public class LeaseCalculationController {

  @Autowired
  private CarServiceProxy carServiceProxy;

  @Autowired
  private InterestRateServiceProxy interestRateProxy;

  @Autowired
  private CustomerServiceProxy customerServiceProxy;

  private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

  /**
   * Calculate lease rate.
   *
   * @param carId ID of car object <em>(retrieved from car-service)</em>
   * @param mileage annual mileage in kilometers
   * @param duration lease contract duration in months
   * @param interestRateId ID of Interest Rate object <em>(retrieved from
   *        interest-calculation-service)</em>
   * @param customerId ID of the customer
   * @return Returns a {@link ResponseEntity} containing a {@link LeaseRateCalculation} object
   */
  @GetMapping("/leaserates/car/{carId}/mileage/{mileage}/duration/{duration}/"
      + "interestrate/{interestRateId}/customer/{customerId}")
  public ResponseEntity<?> calculateLeaseRate(@PathVariable int carId, @PathVariable int mileage,
      @PathVariable int duration, @PathVariable int interestRateId, @PathVariable int customerId) {

    final ResponseEntity<LeaseRateCalculation> responseEntity;

    // get car object from car-service
    final Optional<CarBean> optionalCarBean = carServiceProxy.getCarById(carId);

    // get interest rate object from interest-rate-calculation-service
    final Optional<InterestRateBean> optionalInterestRateBean =
        interestRateProxy.getInterestById(interestRateId);

    final Optional<CustomerBean> optionalCustomerBean =
        customerServiceProxy.getCustomerById(customerId);

    // check if containers are present
    if (optionalCarBean.isPresent() && optionalInterestRateBean.isPresent()
        && optionalCustomerBean.isPresent()) {

      // create lease calculation object
      LeaseRateCalculation leaseRateCalculation = new LeaseRateCalculation(optionalCarBean.get(),
          optionalInterestRateBean.get(), optionalCustomerBean.get(), mileage, duration);

      // calculate lease rate
      leaseRateCalculation.calculate();

      responseEntity = new ResponseEntity<>(leaseRateCalculation, HttpStatus.OK);

      logger.info("Calculate Lease Rate --> Response Code -> {} - Response -> {} ",
          responseEntity.getStatusCodeValue(), responseEntity.getBody());

    } else {

      responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return responseEntity;
  }

}
