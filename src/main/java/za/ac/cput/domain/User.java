/* User.java
User model class
Author: Lyle Solomons (230123872)
Date: 25 March 2026
*/

package za.ac.cput.domain;

/**
 * User class represents a user in our system with attributes like id, name, username, password, email, and role.
 */

public class User {
    private int userId;
    private String fullName;
    private String username;
    private String password;
    private String email;

    //Default constructor.
    public User(){

    }

    //Private constructor for Builder pattern.
    private User(Builder builder){
        this.userId = builder.userId;
        this.fullName = builder.fullName;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    // Builder pattern
    public static class Builder {
        private int userId;
        private String fullName;
        private String username;
        private String password;
        private String email;

        // Setter methods for Builder, returns a builder for chaining
        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.getUserId();
            this.fullName = user.getFullName();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.email = user.getEmail();
            return this;
        }

        // builds the user object from the Builder
        public User build(){
            return new User(this);
        }
    }

}
