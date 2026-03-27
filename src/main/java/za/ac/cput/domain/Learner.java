/* Learner.java
Learner model class
Author: Ethan Williams(221454780)
Date: 25 March 2026
*/
package za.ac.cput.domain;

import java.time.LocalDate;


 // The Learner class represents a learner entity in the system.
 //It stores learner-related information and uses the Builder pattern.

public class Learner {
    private String learnerId;
    private String learnerNumber;
    private String licenseType;
    private LocalDate dateRegistered;
    private String userId;

    //Default constructor
    public Learner() {

    }

    //Constructor that initializes fields using the Builder
    private Learner(Builder builder) {
        this.learnerId = builder.learnerId;
        this.learnerNumber = builder.learnerNumber;
        this.licenseType = builder.licenseType;
        this.dateRegistered = builder.dateRegistered;
        this.userId = builder.userId;
    }

   //Getter methods
    public String getLearnerId() {
        return learnerId;
    }

    public String getLearnerNumber() {
        return learnerNumber;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    public String getUserId() {
        return userId;
    }

    //Static Builder class for constructing Learner objects
    public static class Builder {

        private String learnerId;
        private String learnerNumber;
        private String licenseType;
        private LocalDate dateRegistered;
        private String userId;

       //Setter methods
        public Builder setLearnerId(String learnerId) {
            this.learnerId = learnerId;
            return this;
        }

        public Builder setLearnerNumber(String learnerNumber) {
            this.learnerNumber = learnerNumber;
            return this;
        }

        public Builder setLicenseType(String licenseType) {
            this.licenseType = licenseType;
            return this;
        }

        public Builder setDateRegistered(LocalDate dateRegistered) {
            this.dateRegistered = dateRegistered;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        // Copies values from an existing Learner object
        public Builder copy(Learner learner) {
            this.learnerId = learner.learnerId;
            this.learnerNumber = learner.learnerNumber;
            this.licenseType = learner.licenseType;
            this.dateRegistered = learner.dateRegistered;
            this.userId = learner.userId;
            return this;
        }

        // Builds and returns a Learner object
        public Learner build() {
            return new Learner(this);
        }
    }
}
