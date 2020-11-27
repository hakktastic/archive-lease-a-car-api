package nl.svb.leaseacarapi.leasecalculationservice.controller;

import java.util.List;
import java.util.Optional;
import nl.svb.leaseacarapi.leasecalculationservice.entity.Car;
import nl.svb.leaseacarapi.leasecalculationservice.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Rest Controller for Car Service.
 *
 * @author HAKKI CABUK
 *
 */
@RestController
public class CarController {

  @Autowired
  private CarRepository repository;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * Create Car Entity.
   *
   * @param car {@link Car} data
   * @return Returns a {@link Car} Entity
   */
  @PostMapping("/cars")
  public ResponseEntity<?> createCar(@RequestBody Car car) {

    final Car carEntity = repository.save(car);
    return new ResponseEntity<>(carEntity, HttpStatus.CREATED);
  }

  /**
   * Delete Car Entity.
   *
   * @param id ID of Car Entity
   * @return Returns HTTP Response Code 202 Accepted if Car is deleted
   */
  @DeleteMapping("/cars/{id}")
  public ResponseEntity<?> deleteCar(@PathVariable int id) {

    final Car carEntity = repository.getOne(id);
    repository.delete(carEntity);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  /**
   * Get Car Entity by ID.
   *
   * @param id ID of car
   * @return Returns a {@link Car} entity
   */
  @GetMapping("/cars/{id}")
  public ResponseEntity<?> getCar(@PathVariable int id) {

    final ResponseEntity<Car> responseEntity;
    final Optional<Car> optionalCarEntity = repository.findById(id);

    if (optionalCarEntity.isPresent()) {

      responseEntity = new ResponseEntity<>(optionalCarEntity.get(), HttpStatus.OK);

      logger.info("Get Customer by ID --> Response Code -> {} - Response -> {} ",
          responseEntity.getStatusCodeValue(), responseEntity.getBody());

    } else {

      responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    return responseEntity;
  }

  /**
   * Get all Car Entities.
   *
   * @return Returns a {@link List} with Car Entities.
   */
  @GetMapping("/cars")
  public ResponseEntity<?> getCars() {

    final List<Car> careEntityList = repository.findAll();

    if (!careEntityList.isEmpty()) {

      return new ResponseEntity<>(careEntityList, HttpStatus.OK);

    } else {

      return new ResponseEntity<>("No Car Entities found", HttpStatus.NO_CONTENT);
    }
  }

}
