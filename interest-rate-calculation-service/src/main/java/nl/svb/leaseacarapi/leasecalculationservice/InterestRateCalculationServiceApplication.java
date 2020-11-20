package nl.svb.leaseacarapi.leasecalculationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InterestRateCalculationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(InterestRateCalculationServiceApplication.class, args);
  }

}
