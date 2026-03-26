/* Schedule.java  
Schedule model class 
Author Angelo Adams (230450431) 
Date: 04 March 2026 */
package za.ac.cput.domain;

//Imports
import java.util.Objects;

public class Schedule {

    private int scheduleId;
    private int instructorId;
    private int vehicleId;
    private String status;

//default contructor
    public Schedule(){
        
    }
        //constructor arg
    private Schedule(Builder builder) {
        this.scheduleId = builder.scheduleId;
        this.instructorId = builder.instructorId;
        this.vehicleId = builder.vehicleId;
        this.status = builder.status;
    }


    public int getScheduleId() { return scheduleId; }
    public int getInstructorId() { return instructorId; }
    public int getVehicleId() { return vehicleId; }
    public String getStatus() { return status; }

    // Builder patterns
    public static class Builder {
        private int scheduleId;
        private int instructorId;
        private int vehicleId;
        private String status;

        //setters
        public Builder setScheduleId(int scheduleId) {
            this.scheduleId = scheduleId;
            return this;
        }

        public Builder setInstructorId(int instructorId) {
            this.instructorId = instructorId;
            return this;
        }

        public Builder setVehicleId(int vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Schedule schedule) {
            this.scheduleId = schedule.scheduleId;
            this.instructorId = schedule.instructorId;
            this.vehicleId = schedule.vehicleId;
            this.status = schedule.status;
            return this;
        }

        public Schedule build() {
            return new Schedule(this);
        }
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", instructorId=" + instructorId +
                ", vehicleId=" + vehicleId +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, instructorId, vehicleId, status);
    }
}
