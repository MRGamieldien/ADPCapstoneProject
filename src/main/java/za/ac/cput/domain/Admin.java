package za.ac.cput.domain;

/**
 * The Admin class represents an administrator entity in the system.
 */
public class Admin {
    private int adminId;
    private String department;
    private int accessLevel;
    private int userId;

    /**
     * Default constructor 
     */
    public Admin() {

    }
    /*
     * Parameterized constructor to initialize all fields
     */
    public Admin(int adminId, String department, int accessLevel, int userId) {
        this.adminId = adminId;
        this.department = department;
        this.accessLevel = accessLevel;
        this.userId = userId;
    }

    /**
     * Constructor that uses the Builder object to initialize fields
     */
    public Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.department = builder.department;
        this.accessLevel = builder.accessLevel;
        this.userId = builder.userId;
    }

    // Getter methods to access private fields

    public int getAdminId() {
        return adminId;
    }

    public String getDepartment() {
        return department;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public int getUserId() {
        return userId;
    }

    /**
     * Static Builder class that implements the Builder Design Pattern.
     */
    public static class Builder {

        private int adminId;
        private String department;
        private int accessLevel;
        private int userId;

        public Builder setAdminId(int adminId) {
            this.adminId = adminId;
            return this;
        }
        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public Builder setAccessLevel(int accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        /**
         * Copies values from an existing Admin object
         */
        public Builder copy(Admin admin) {
            this.adminId = admin.adminId;
            this.department = admin.department;
            this.accessLevel = admin.accessLevel;
            this.userId = admin.userId;
            return this;
        }

        /**
         * Builds and returns a new Admin object
         */
        public Admin build() {
            return new Admin(this);
        }
    }
}
