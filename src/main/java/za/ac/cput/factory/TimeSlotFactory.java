/* TimeSlotFactory.java
   Factory class for creating Vehicle objects
   Author: Redah Gamieldien (222641681)
   Date: 26 March 2026
 */

package za.ac.cput.factory;

import za.ac.cput.domain.TimeSlot;
import za.ac.cput.util.Helper;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 * A factory class that handles creating TimeSlot objects,
 * making sure each one is set up correctly and ready to use.
 */
public class TimeSlotFactory {

    /**
     * Creates and returns a TimeSlot with all attributes.
     */
    public static TimeSlot createTimeSlot(String slotId,
                                          LocalTime startTime,
                                          LocalTime endTime,
                                          LocalDate date,
                                          boolean isBooked) {

        // Validate that no field is null
        if (Helper.isNullOrEmpty(slotId) ||
                startTime == null ||
                endTime == null ||
                date == null) {
            return null;
        }

        //This is to validate that endTime is after startTime
        if (!endTime.isAfter(startTime)) {
            return null;

        }


        return new TimeSlot.Builder()
                .setSlotID(slotId)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setDate(date)
                .setIsBooked(isBooked)
                .build();
    }

}

