/* Booking.java
Booking model class
Author: Rameez Karriem (222357320)
Date: 25 March 2026
*/
package za.ac.cput.domain;

import java.time.LocalDate;

// Immutable Booking entity with Builder pattern for flexible construction
public class Booking {
    private String bookingId;      // Unique identifier for the booking
    private LocalDate bookingDate; // Date of the booking
    private String timeSlot;       // Time slot for the booking (as String)
    private String status;         // Current status of the booking
    private String learnerId;      // ID of the learner who made the booking
    private String instructorId;   // ID of the instructor assigned to the booking

    // Public default constructor
    public Booking() {
    }

    // Private constructor called by Builder's build() method
    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.bookingDate = builder.bookingDate;
        this.timeSlot = builder.timeSlot;
        this.status = builder.status;
        this.learnerId = builder.learnerId;
        this.instructorId = builder.instructorId;
    }

    // Getters - no setters to maintain immutability
    public String getBookingId() {
        return bookingId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getStatus() {
        return status;
    }

    public String getLearnerId() {
        return learnerId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    // Builder class for constructing Booking objects
    public static class Builder {
        private String bookingId;
        private LocalDate bookingDate;
        private String timeSlot;
        private String status;
        private String learnerId;
        private String instructorId;

        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setBookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder setTimeSlot(String timeSlot) {
            this.timeSlot = timeSlot;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setLearnerId(String learnerId) {
            this.learnerId = learnerId;
            return this;
        }

        public Builder setInstructorId(String instructorId) {
            this.instructorId = instructorId;
            return this;
        }

        // Copies values from an existing Booking object to the Builder
        public Builder copy(Booking booking) {
            this.bookingId = booking.bookingId;
            this.bookingDate = booking.bookingDate;
            this.timeSlot = booking.timeSlot;
            this.status = booking.status;
            this.learnerId = booking.learnerId;
            this.instructorId = booking.instructorId;
            return this;
        }

        // Builds and returns a new Booking object
        public Booking build() {
            return new Booking(this);
        }
    }
}
