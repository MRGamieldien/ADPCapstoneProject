/* Schedule.java  
Schedule model class 
Author Angelo Adams (230450431) 
Date: 04 March 2026 */
package za.ac.cput.domain;

import java.time.LocalDate;

public class Schedule {

    private String scheduleId;
    private String instructorId;
    private LocalDate date;;
    private String status;

//default contructor
    public Schedule(){
        
    }
        //constructor arg
    private Schedule(Builder builder) {
        this.scheduleId = builder.scheduleId;
        this.instructorId = builder.instructorId;
        this.date = builder.date;
        this.status = builder.status;
    }


    public String getScheduleId() { return scheduleId; }
    public String getInstructorId() { return instructorId; }
    public LocalDate getdate() { return date; }
    public String getStatus() { return status; }

    // Builder patterns
    public static class Builder {
        private String scheduleId;
        private String instructorId;
        private LocalDate date;
        private String status;

        //setters
        public Builder setScheduleId(String scheduleId) {
            this.scheduleId = scheduleId;
            return this;
        }

        public Builder setInstructorId(String instructorId) {
            this.instructorId = instructorId;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        
         // Copies values from an existing Schedule object to the Builder.
         // This method is used for creating modified copies of existing schedule types.
        public Builder copy(Schedule schedule) {
            this.scheduleId = schedule.scheduleId;
            this.instructorId = schedule.instructorId;
            this.date = schedule.date;
            this.status = schedule.status;
            return this;
        }

         // Builds and returns a new Schedule object.
         // This method validates  and creates the immutable Schedule
        public Schedule build() {
            return new Schedule(this);
        }
    }
}
