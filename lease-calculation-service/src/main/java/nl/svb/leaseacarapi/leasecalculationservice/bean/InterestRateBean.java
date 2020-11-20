package nl.svb.leaseacarapi.leasecalculationservice.bean;

import java.time.LocalDate;

/**
 * Interest Rate Bean.
 *
 * @author HAKKI CABUK
 *
 */
public class InterestRateBean {

  private int id;
  private double interestRate;
  private LocalDate startDate;

  /**
   * Default constructor.
   */
  public InterestRateBean() {}

  /**
   * Constructor with all fields.
   *
   * @param id ID of interest rate object
   * @param interestRate interest rate
   * @param startDate start date for the interest rate
   */
  public InterestRateBean(int id, double interestRate, LocalDate startDate) {

    this.id = id;
    this.interestRate = interestRate;
    this.startDate = startDate;
  }

  public int getId() {
    return id;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }
}
