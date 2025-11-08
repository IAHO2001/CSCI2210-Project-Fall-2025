import java.util.ArrayList;
import java.util.List;

/**
 * LoginManager.java
 * Tracks logged-in users and provides basic login/logout functionality.
 */
public class LoginManager {
    private List<User> loggedInUsers;

    /**
     * Constructor
     */
    public LoginManager() {
        this.loggedInUsers = new ArrayList<>();
    }

    /**
     * Attempt login by matching username (name) and password in allUsers list.
     * @param username name used as login key
     * @param password password
     * @param allUsers list of users to check
     * @return User logged in or null if failed
     */
    public User login(String email, String password, List<User> users) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                if (!loggedInUsers.contains(user)) loggedInUsers.add(user);
                return user;
            }
        }
        return null;
    }

    /**
     * Logout a user.
     * @param user user to log out
     */
    public void logout(User user) {
        loggedInUsers.remove(user);
    }

    /**
     * Check if user is logged in.
     * @param user user to check
     * @return true if logged in
     */
    public boolean isUserLoggedIn(User user) {
        return loggedInUsers.contains(user);
    }

    /**
     * Get list of logged in users.
     * @return list
     */
    public List<User> getLoggedInUssers() {
        return loggedInUsers;
    }
}