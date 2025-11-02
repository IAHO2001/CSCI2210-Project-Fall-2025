import java.util.ArrayList;
import java.util.List;

/**
 * LoginManager.java
 * Tracks logged-in users and provides basic login/logout functionality.
 */
public class LoginManager {
    private List<User> loggedInUsers;

    public LoginManager() {
        loggedInUsers = new ArrayList<>();
    }

    /**
     * Attempt login by matching username (name) and password in allUsers list.
     * @param username name used as login key
     * @param password password
     * @param allUsers list of users to check
     * @return User logged in or null if failed
     */
    public User login(String username, String password, List<User> allUsers) {
        for (User u : allUsers) {
            if (u.getName().equals(username) && u.getPassword().equals(password)) {
                if (!loggedInUsers.contains(u)) loggedInUsers.add(u);
                return u;
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
        return new ArrayList<>(loggedInUsers);
    }
}