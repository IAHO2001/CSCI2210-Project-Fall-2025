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

    public int getAdminID() { return adminID; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return ("Admin ID: " + adminID + ", Name: " + this.getName() + ", Role: " + role);
    }
}
