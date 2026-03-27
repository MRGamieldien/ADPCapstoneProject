/* ScheduleFactory.java  
ScheduleFactory model class 
Author Angelo Adams (230450431) 
Date: 04 March 2026 */
package za.ac.cput.factory;

import za.ac.cput.domain.MockTest;
import za.ac.cput.domain.Schedule;
import za.ac.cput.util.Helper;

//SCheduleFactory class
 
 // Responsible for creating schedule objects with validation.
public class ScheduleFactory {

    public static Schedule createSchedule(String scheduleId, String instructorId, String vehicleId, String status ){
// Validate scheduleId , instructorId, vehicleId & status (must not be null or empty)
        if (Helper.isNullOrEmpty(scheduleId)) {
            return null;

        }
//build and return Schedule object using builder pattern
        return new Schedule.Builder().setScheduleId(scheduleId)
                .setInstructorId(instructorId)
                .setVehicleId(vehicleId)
                .setStatus(status)
                .build();
    }
}


