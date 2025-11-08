/**
 * Admin.java
 * Admin inherits Person and has a role.
 */
public class Admin extends Person {
    private int adminID;
    private String role;

    /**
     * Constructs an Admin.
     * @param adminID admin id
     * @param name name
     * @param role role
     */
    public Admin(String name, String email, String phoneNumber, String role) {
        super(name, email, phoneNumber);
        this.adminID = IDgenerator.generateAdminID();
        this.role = role;
    }

    /**
     * This method returns the admins ID
     * @return int adminID
     */
    public int getAdminID() { return adminID; }

    /**
     * This method returns the admin persons role
     * @return String role
     */
    public String getRole() { return role; }

    /**
     * This mehtod receives string role and sets it as the admins role
     * @param role
     */
    public void setRole(String role) { this.role = role; }

    /**
     * This method presents genral admin information.
     * @return String
     */
    @Override
    public String toString() {
        return ("Admin ID: " + adminID + ", Name: " + this.getName() + ", Role: " + role);
    }
}
