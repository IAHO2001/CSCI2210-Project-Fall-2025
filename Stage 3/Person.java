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

    /**
     * Constructor
     * @param name
     * @param email
     * @param phoneNumber
     */
    public Person(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method returns the persons name
     * @return String name
     */
    public String getName(){
        return name;
    }

    /**
     * This method receives string name and sets it as the persons name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * This method returns the persons email
     * @return String email
     */
    public String getEmail(){
        return email;
    }

    /**
     * This method receives the string email and sets it as the persons email
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * This method returns the persons phone number
     * @return String phoneNumber
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * This method receives the string PhoneNumber and sets it as the persons phone number
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

}
