/* Booking.java
Booking model class
Author: Rameez Karriem (222357320)
Date: 25 March 2026
*/
package za.ac.cput.domain;

/**
 * Represents a booking entity in the system.
 * This class is immutable - once created, its state cannot be changed.
 * Uses the Builder pattern for object construction.
 */
public class Booking {
    private String bookingId;      // Unique identifier for the booking
    private String bookingDate;    // Date of the booking
    private String timeSlot;       // Time slot for the booking 
    private String status;         // Current status of the booking
    private int learnerId;         // ID of the learner who made the booking
    private int instructorId;      // ID of the instructor assigned to the booking

    /**
     * public default constructor.
     */
    public Booking() {
    }

    /**
     * Constructor that accepts a Builder object and initializes the Booking.
     * This is called by the Builder's build() method.
     *
     * @param builder The Builder object containing the booking data
     */
    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.bookingDate = builder.bookingDate;
        this.timeSlot = builder.timeSlot;
        this.status = builder.status;
        this.learnerId = builder.learnerId;
        this.instructorId = builder.instructorId;
    }

    // Getters - no setters provided to maintain immutability
    // Once a Booking object is created, its fields cannot be modified

    /**
     * Gets the booking ID.
     * @return The unique booking identifier
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Gets the booking date.
     * @return The date of the booking
     */
    public String getBookingDate() {
        return bookingDate;
    }

    /**
     * Gets the time slot.
     * @return The time slot for the booking
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * Gets the booking status.
     * @return The current status of the booking
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the learner ID.
     * @return The ID of the learner who made the booking
     */
    public int getLearnerId() {
        return learnerId;
    }

    /**
     * Gets the instructor ID.
     * @return The ID of the instructor assigned to the booking
     */
    public int getInstructorId() {
        return instructorId;
    }
    /**
     * Builder class for constructing Booking objects.
     * Implements the Builder design pattern to allow flexible object creation
     * while maintaining immutability of the final Booking object.
     */
    public static class Builder {
        // Fields mirroring the Booking class
        private String bookingId;
        private String bookingDate;
        private String timeSlot;
        private String status;
        private int learnerId;
        private int instructorId;

        /**
         * Sets the booking ID.
         * @param bookingId The unique booking identifier
         * @return The current Builder instance (for method chaining)
         */
        public Builder setBookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;  // Returns the Builder object for fluent interface
        }

        /**
         * Sets the booking date.
         * @param bookingDate The date of the booking
         * @return The current Builder instance (for method chaining)
         */
        public Builder setBookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        /**
         * Sets the time slot.
         * @param timeSlot The time slot for the booking
         * @return The current Builder instance (for method chaining)
         */
        public Builder setTimeSlot(String timeSlot) {
            this.timeSlot = timeSlot;
            return this;
        }

        /**
         * Sets the booking status.
         * @param status The current status of the booking
         * @return The current Builder instance (for method chaining)
         */
        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        /**
         * Sets the learner ID.
         * @param learnerId The ID of the learner making the booking
         * @return The current Builder instance (for method chaining)
         */
        public Builder setLearnerId(int learnerId) {
            this.learnerId = learnerId;
            return this;
        }

        /**
         * Sets the instructor ID.
         * @param instructorId The ID of the assigned instructor
         * @return The current Builder instance (for method chaining)
         */
        public Builder setInstructorId(int instructorId) {
            this.instructorId = instructorId;
            return this;
        }

        /**
         * Copies values from an existing Booking object to the Builder.
         * Useful for creating modified copies of existing bookings.
         *
         * @param booking The existing Booking object to copy from
         * @return The current Builder instance (for method chaining)
         */
        public Builder copy(Booking booking) {
            this.bookingId = booking.bookingId;
            this.bookingDate = booking.bookingDate;
            this.timeSlot = booking.timeSlot;
            this.status = booking.status;
            this.learnerId = booking.learnerId;
            this.instructorId = booking.instructorId;
            return this;
        }

        /**
         * Builds and returns a new Booking object.
         * This method creates the immutable Booking instance using the
         * values set in the Builder.
         *
         * @returns A new Booking object with the configured properties
         */
        public Booking build() {
            return new Booking(this);
        }
    }
}

