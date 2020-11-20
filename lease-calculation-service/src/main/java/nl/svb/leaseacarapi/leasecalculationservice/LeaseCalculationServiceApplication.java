package nl.svb.leaseacarapi.leasecalculationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("nl.svb.leaseacarapi.leasecalculationservice")
@EnableDiscoveryClient
public class LeaseCalculationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(LeaseCalculationServiceApplication.class, args);
  }

}
