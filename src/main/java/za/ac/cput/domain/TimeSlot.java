/* TimeSlot.java
   TimeSlot model class
   Author: Redah Gamieldien (222641681)
   Date: 25 March 2025
 */

package za.ac.cput.domain;

import java.time.LocalDate;
import java.time.LocalTime;

 // Represents a bookable time slot for a driving lesson.
public class TimeSlot {
    private String slotId;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    private boolean isBooked;


    //Default constructor.
    public TimeSlot(){
    }


    //Private constructor for Builder pattern.
    private TimeSlot(Builder builder){
        this.slotId = builder.slotId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.date = builder.date;
        this.isBooked = builder.isBooked;
    }

    // Returns the unique slot ID. 
    public String getSlotId() {return slotId;}

    // Returns the start time of the slot. 
    public LocalTime getStartTime() {return startTime;}

    // Returns the end time of the slot. 
    public LocalTime getEndTime() {return endTime;}

    // Returns the date of the slot. 
    public LocalDate getDate() {return date;}

    ///Returns true if the slot is currently booked. 
    public boolean isBooked() {return isBooked;}


   
   // Builder for constructing TimeSlot instances step by step.
    public static class Builder{
        private String slotId;
        private LocalTime startTime;
        private LocalTime endTime;
        private LocalDate date;
        private boolean isBooked;

        public Builder setSlotID(String slotId){
            this.slotId = slotId;
            return this;
        }

        public Builder setStartTime(LocalTime startTime){
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(LocalTime endTime){
            this.endTime = endTime;
            return this;
        }

        public Builder setDate(LocalDate date){
            this.date = date;
            return this;
        }

        public Builder setIsBooked(boolean isBooked){
            this.isBooked = isBooked;
            return this;
        }

        public Builder copy(TimeSlot timeSlot){
            this.slotId = timeSlot.getSlotId();
            this.startTime = timeSlot.getStartTime();
            this.endTime = timeSlot.getEndTime();
            this.date = timeSlot.getDate();
            this.isBooked = timeSlot.isBooked();
            return this;
        }

        // builds the TimeSlot object from the Builder
        public TimeSlot build() {
            return new TimeSlot(this);
        }
    }
}
