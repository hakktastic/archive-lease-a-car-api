package nl.svb.leaseacarapi.leasecalculationservice.bean;

public class CustomerBean {

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
  public CustomerBean() {}

  /**
   * Constructor.
   *
   * @param id ID of Customer Entity
   * @param name first and last name of user
   * @param street the street of the user
   * @param houseNumber the house number of the user
   * @param zipcode the zip code of the user
   * @param place the place of residence of the user
   * @param email the email address of the user
   * @param phoneNumber the phone number of the user
   */
  public CustomerBean(int id, String name, String street, int houseNumber, String zipcode,
      String place, String email, int phoneNumber) {

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
