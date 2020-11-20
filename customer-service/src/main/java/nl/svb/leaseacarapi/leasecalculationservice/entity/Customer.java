package nl.svb.leaseacarapi.leasecalculationservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * JPA Customer entity.
 *
 * @author HAKKI
 *
 */
@Entity
public class Customer {

  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String street;
  private int houseNumber;
  private String zipcode;
  private String place;
  private String email;
  private int phoneNumber;


  /**
   * Default Constructor.
   */
  public Customer() {}

  /**
   * Constructor.
   *
   * @param id ID of customer
   * @param name first and last name of customer
   * @param street the street of the customer
   * @param houseNumber the house number of the customer
   * @param zipcode the zip code of the customer
   * @param place the place of residence of the ucustomerser
   * @param email the email address of the customer
   * @param phoneNumber the phone number of the customer
   */
  public Customer(int id, String name, String street, int houseNumber, String zipcode, String place,
      String email, int phoneNumber) {

    this.id = id;
    this.name = name;
    this.street = street;
    this.houseNumber = houseNumber;
    this.zipcode = zipcode;
    this.place = place;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public int getHouseNumber() {
    return houseNumber;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPhoneNumber() {
    return phoneNumber;
  }

  public String getPlace() {
    return place;
  }

  public String getStreet() {
    return street;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setHouseNumber(int houseNumber) {
    this.houseNumber = houseNumber;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
}