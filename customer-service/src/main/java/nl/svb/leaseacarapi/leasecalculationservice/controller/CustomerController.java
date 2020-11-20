package nl.svb.leaseacarapi.leasecalculationservice.controller;

import java.util.List;
import java.util.Optional;
import nl.svb.leaseacarapi.leasecalculationservice.entity.Customer;
import nl.svb.leaseacarapi.leasecalculationservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Customer Service.
 *
 * @author HAKKI CABUK
 *
 */
@RestController
public class CustomerController {

  @Autowired
  private CustomerRepository repository;

  /**
   * Create Customer.
   *
   * @param customer {@link Customer} data
   * @return Returns a {@link Customer} Entity
   */
  @PostMapping("/customers")
  public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {

    final Customer customerEntity = repository.save(customer);
    return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
  }

  /**
   * Delete Customer Entity.
   *
   * @param id ID of Customer Entity
   * @return Returns HTTP Response Code 202 Accepted if Customer is deleted
   */
  @DeleteMapping("/customers/{id}")
  public ResponseEntity<?> deleteCustomer(@PathVariable int id) {

    final Customer customerEntity = repository.getOne(id);
    repository.delete(customerEntity);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  /**
   * Get all Customer Entities.
   *
   * @return Returns a {@link List} with all Customer Entities
   *
   */
  @GetMapping("/customers")
  public ResponseEntity<?> getAllCustomers() {

    final List<Customer> customerEntityList = repository.findAll();

    if (!customerEntityList.isEmpty()) {

      return new ResponseEntity<>(customerEntityList, HttpStatus.OK);

    } else {

      return new ResponseEntity<>("No customer Entities found", HttpStatus.NO_CONTENT);
    }
  }

  /**
   * Get Customer Entity by ID.
   *
   * @param id Object ID of Customer Entity
   *
   * @return Returns a {@link Customer} Entity
   */
  @GetMapping("/customers/{id}")
  public ResponseEntity<?> getCustomerById(@PathVariable int id) {

    final Optional<Customer> optionalCustomerEntity = repository.findById(id);

    if (optionalCustomerEntity.isPresent()) {

      return new ResponseEntity<>(optionalCustomerEntity.get(), HttpStatus.OK);
    } else {

      return new ResponseEntity<>("Customer Entity not found for provided ID -> " + id,
          HttpStatus.NO_CONTENT);
    }
  }

  /**
   * Get Customer Entity by name.
   *
   * @param name First- and last name of Customer Entity
   * @return Returns a {@link Customer} Entity
   */
  @GetMapping("/customers/name/{name}")
  public ResponseEntity<?> getCustomerByName(@PathVariable String name) {


    final Optional<Customer> optionalCustomerEntity = repository.findByName(name);

    if (optionalCustomerEntity.isPresent()) {

      return new ResponseEntity<>(optionalCustomerEntity.get(), HttpStatus.OK);

    } else {

      return new ResponseEntity<>("Customer Entity not found for name -> " + name,
          HttpStatus.NO_CONTENT);
    }
  }

}
