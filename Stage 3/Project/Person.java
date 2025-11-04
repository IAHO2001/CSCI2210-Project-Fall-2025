/**
 * This class creates a Person with attributes name email and phone number to be use in 
 * inheritance
 * Contains 3 instance variables
 * @author Jacob Chavez
 * @date Nov 3, 2025
 */
public class Person {
    //instance variables
    private String name;
    private String email;
    private String phoneNumber;

    //Constructor
    public Person(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method return the name of person
     */
    public String getName(){
        return name;
    }

    /**
     * This method sets the name of a person
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * This method returns the email of a person
     */
    public String getEmail(){
        return email;
    }

    /**
     * This method sets the email of a person
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * This method returns the phone number of a person
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * This method sets the phone number of a person
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

}
