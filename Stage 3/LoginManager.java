import java.util.ArrayList;
import java.util.List;

/**
 * LoginManager handles authentication for Admins, Users (Customers), and DeliveryDrivers.
 * Tracks who is currently logged in and provides methods to check login status and logout.
 */
public class LoginManager {
    // instance variable
    private List<Person> loggedInPeople;

    /**
     * Constructor
     */
    public LoginManager() {
        loggedInPeople = new ArrayList<>();
    }

    /**
     * Logs in an Admin by email and passwrod
     * @param email Admin's email
     * @param password Admins passwrod
     * @param admins List of all admins
     * @return Admin object if found, null otherwise
     */
    public Admin loginAdmin(String email, String password, List<Admin> admins) {
        for (Admin admin : admins) {
            if (admin.getEmail().equalsIgnoreCase(email) && admin.getPassword().equals(password)) {
                if (!loggedInPeople.contains(admin)) {
                    loggedInPeople.add(admin);
                }
                return admin;
            }
        }
        return null;
    }

    /**
     * Logs in a User (Customer) by email and password.
     * @param email User email
     * @param password User password
     * @param users List of all users
     * @return User object if email/password match, null otherwise
     */
    public User loginUser(String email, String password, List<User> users) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                if (!loggedInPeople.contains(user)) {
                    loggedInPeople.add(user);
                }
                return user;
            }
        }
        return null;
    }

    /**
     * Logs in a DeliveryPerson by email and password
     * @param email DeliveryPerson email
     * @param passwrod Delivery Person paswrod
     * @param drivers List of all delivery personnel
     * @return DeliveryPerson object if found, null otherwise
     */
    public DeliveryPerson loginDriver(String email, String password, List<DeliveryPerson> drivers) {
        for (DeliveryPerson driver : drivers) {
            if (driver.getEmail().equalsIgnoreCase(email) && driver.getPassword().equals(password)) {
                if (!loggedInPeople.contains(driver)) {
                    loggedInPeople.add(driver);
                }
                return driver;
            }
        }
        return null;
    }

    /**
     * Logs out a person from the system.
     * @param person Admin, User, or DeliveryPerson to logout
     */
    public void logout(Person person) {
        loggedInPeople.remove(person);
    }

    /**
     * Checks if a person is currently logged in.
     * @param person Admin, User, or DeliveryPerson
     * @return true if logged in, false otherwise
     */
    public boolean isLoggedIn(Person person) {
        return loggedInPeople.contains(person);
    }

    /**
     * Returns a list of all currently logged-in people.
     * @return List<Person>
     */
    public List<Person> getLoggedInPeople() {
        return new ArrayList<>(loggedInPeople);
    }
}
