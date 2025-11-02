/**
 * Admin.java
 * Admin inherits Person and has a role.
 */
public class Admin extends Person {
    private String role;

    /**
     * Constructs an Admin.
     * @param adminID admin id
     * @param name name
     * @param role role
     */
    public Admin(int adminID, String name, String role) {
        super(adminID, name);
        this.role = role;
    }

    public int getAdminID() { return id; }
    public void setAdminiD(int ID) { this.id = ID; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "Admin ID: " + id + ", Name: " + name + ", Role: " + role;
    }
}