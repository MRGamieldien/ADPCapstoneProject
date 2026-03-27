/*
 * TimeSlotRepository.java
 * TimeSlotRepository class - handles CRUD operations for TimeSlot objects
 * Author: Redah Gamieldien (222641681)
 * Date: 27 March 2026
 */
package za.ac.cput.repository;

import za.ac.cput.domain.TimeSlot;
import java.util.ArrayList;
import java.util.List;

public class TimeSlotRepository implements IRepository<TimeSlot, String> {

    // Singleton instance of TimeSlotRepository
    public static TimeSlotRepository repository = null;

    // List to store TimeSlot objects
    private List<TimeSlot> timeSlotList;

    // Private constructor to prevent external instantiation
    private TimeSlotRepository() {
        timeSlotList = new ArrayList<>();
    }

    // Method to get the singleton instance of TimeSlotRepository
    public static TimeSlotRepository getRepository() {
        if (repository == null) {
            repository = new TimeSlotRepository();
        }
        return repository;
    }

    // Create a new TimeSlot and add to the list
    @Override
    public TimeSlot create(TimeSlot timeSlot) {
        boolean success = timeSlotList.add(timeSlot);
        if (success) {
            return timeSlot;
        }
        return null;
    }

    // Read a TimeSlot by its ID
    @Override
    public TimeSlot read(String slotId) {
        for (TimeSlot timeSlot : timeSlotList) {
            if (timeSlot.getSlotId().equals(slotId)) {
                return timeSlot;
            }
        }
        return null;
    }

    // Update an existing TimeSlot
    @Override
    public TimeSlot update(TimeSlot timeSlot) {
        String id = timeSlot.getSlotId();
        TimeSlot oldTimeSlot = read(id);

        if (oldTimeSlot != null) {
            timeSlotList.remove(oldTimeSlot); // Remove old entry
            timeSlotList.add(timeSlot);       // Add updated entry
            return timeSlot;
        }
        return null;
    }

    // Delete a TimeSlot by ID
    @Override
    public boolean delete(String id) {
        TimeSlot timeSlotToDelete = read(id);

        if (timeSlotToDelete != null) {
            timeSlotList.remove(timeSlotToDelete);
            return true;
        }
        return false;
    }

    // Get all TimeSlot objects
    @Override
    public List<TimeSlot> getAll() {
        return timeSlotList;
    }
}
