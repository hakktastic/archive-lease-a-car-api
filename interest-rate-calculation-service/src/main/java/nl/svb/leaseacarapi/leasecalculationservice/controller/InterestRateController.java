package nl.svb.leaseacarapi.leasecalculationservice.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import nl.svb.leaseacarapi.leasecalculationservice.entity.InterestRate;
import nl.svb.leaseacarapi.leasecalculationservice.repository.InterestRateRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Rest Controller for Interest Rate Calculation Service.
 *
 * @author HAKKI CABUK
 *
 */
@RestController
public class InterestRateController {

  @Autowired
  private InterestRateRepository repository;

  private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());


  /**
   * Get Interest Rate Entity based on the ID.
   *
   * @param id ID of the Interest Rate Entity
   * @return Returns {@link InterestRate} Entity
   */
  @GetMapping("/interestrates/{id}")
  public ResponseEntity<?> getInterestById(@PathVariable int id) {

    final ResponseEntity<InterestRate> responseEntity;
    final Optional<InterestRate> optionalInterestRateEntity = repository.findById(id);

    if (optionalInterestRateEntity.isPresent()) {

      responseEntity = new ResponseEntity<>(optionalInterestRateEntity.get(), HttpStatus.OK);

      logger.info("Get Interest Rate by ID --> Response Code -> {} - Response -> {} ",
          responseEntity.getStatusCodeValue(), responseEntity.getBody());

    } else {

      responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return responseEntity;
  }

  /**
   * Get interest rate based on start date.
   *
   * @param startdate start date of interest rate
   * @return Returns a {@link ResponseEntity} containing a {@link InterestRate} container object
   */
  @GetMapping("/interestrates/startdate/{startdate}")
  public ResponseEntity<?> getInterestRateByStartDate(@PathVariable String startdate) {

    final LocalDate date = LocalDate.parse(startdate);

    final Optional<InterestRate> optionalInterestRate = repository.findByStartDate(date);

    if (optionalInterestRate.isPresent()) {

      return new ResponseEntity<>(optionalInterestRate.get(), HttpStatus.OK);

    } else {

      return new ResponseEntity<>("Interest Rate Entity not found for start date -> " + startdate,
          HttpStatus.NO_CONTENT);
    }
  }

  /**
   * Get all interest rates.
   *
   * @return Returns a {@link List} with all the interest rate objects.
   */
  @GetMapping("/interestrates")
  public ResponseEntity<?> getIterestRates() {

    final List<InterestRate> responseList = repository.findAll();

    if (responseList != null && !responseList.isEmpty()) {

      return new ResponseEntity<>(responseList, HttpStatus.OK);

    } else {

      return new ResponseEntity<>("No Interest Rate Entities found", HttpStatus.NO_CONTENT);
    }

  }

}
