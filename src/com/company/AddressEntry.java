package com.company;
import java.util.Collections;
/**
 * The AddressEntry class represents a single Address entry in the AddressBook
 * @author JessicaAsuncion
 */
public class AddressEntry implements Comparable{
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String phone;
    private String email;

    /* default constructor for AddressEntry */
    public AddressEntry(){

    }

    /**
     * Constructor for AddressEntry
     * @param firstName the first name of an AddressEntry
     * @param lastName the last name of an AddressEntry
     * @param street the street of an AddressEntry
     * @param city the state of an AddressEntry
     * @param state the state of an AddressEntry
     * @param zip the zip of an AddressEntry
     * @param phone the phone of an AddressEntry
     * @param email the email of an AddressEntry
     */
    public AddressEntry(String firstName, String lastName, String street,
                        String city, String state, int zip, String phone, String email){
        setFirstName(firstName);
        setLastName(lastName);
        setCity(city);
        setState(state);
        setStreet(street);
        setPhone(phone);
        setZip(zip);
        setEmail(email);
    }

    /**
     * takes all data elements and composes nicely formatted string
     *      prints to console
     * @return contact -the contact of Addressbook
     */
    public String toString(){
        String contact = "First Name: " + firstName + "\n"
                + "Last Name: " + lastName + "\n"
                + "Street: " + street + "\n"
                + "City: " + city + "\n"
                + "State: " + state + "\n"
                + "Zip: " + zip + "\n"
                + "Phone: " + phone + "\n"
                + "Email: " + email + "\n";
        return contact;
    }

    /**
     * get the firstName of the user
      * @return firstName
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * set the input as firstName
      * @param firstName the first name of an AddressEntry
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * get last name from an entry
      * @return lastName
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * set input as lastName
     * @param lastName the last name of an AddressEntry
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * get street from an entry
     * @return street
     */
    public String getStreet(){
        return street;
    }

    /**
     * set input of street as street variable
     * @param street the street of an AddressEntry
     */
    public void setStreet(String street){
        this.street = street;
    }

    /**
     * get city from entry
     * @return city
     */
    public String getCity(){
        return city;
    }

    /**
     * set city from entry
     * @param city the city of an AddressEntry
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     * get state from entry
     * @return state
     */
    public String getState()
    {
        return state;
    }

    /** set input of state as state variable
    * @param state the state of an AddressEntry
    */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * get zip from entry
     * @return zip
     */
    public int getZip(){
        return zip;
    }

    /**
     * set zip from entry
     * @param zip the zip of an AddressEntry
     */
    public void setZip(int zip){
        this.zip = zip;
    }

    /**
     * get phone from entry
     * @return phone
     */
    public String getPhone(){
        return phone;
    }

    /**
     * set phone number from entry
     * @param phone the phone of an AddressEntry
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * get email from entry
     * @return email
     */
    public String getEmail(){
        return email;
    }

    /**
     * set email from entry
     * @param email the email of an AddressEntry
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * To sort last name using collections
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        return this.getLastName().compareTo(((AddressEntry) o).getLastName());
    }

}
