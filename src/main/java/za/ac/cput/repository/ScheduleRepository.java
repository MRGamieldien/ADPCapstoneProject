/*
 * MockTestRepository.java
 * MockTestRepository model class
 * Author: Angelo Adams (230450431)
 * Date: 27 March 2026
 */

package za.ac.cput.repository;

import za.ac.cput.domain.MockTest;
import za.ac.cput.domain.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleRepository implements IRepository<Schedule, String> {


    // Singleton instance of ScheduleRepository
    public static za.ac.cput.repository.ScheduleRepository repository = null;

    // List to store Schedule objects
    private List<Schedule> scheduleList;

    // Private constructor to prevent external instantiation
    private ScheduleRepository() {
        scheduleList = new ArrayList<>();
    }

    // Method to get the singleton instance of ScheduleRepository
    public static za.ac.cput.repository.ScheduleRepository getRepository() {
        if (repository == null) {
            repository = new za.ac.cput.repository.ScheduleRepository();
        }
        return repository;
    }

    // Create a new Schedule and add it to the list
    @Override
    public Schedule create(Schedule schedule) {
        boolean success = scheduleList.add(schedule);
        if(success){
            return schedule;
        }
        return null;
    }


    // Read an Schedule by its ID
    @Override
    public Schedule read(String scheduleId) {
        for(Schedule schedule : scheduleList){
            if(schedule.getScheduleId().equals(scheduleId)){
                return schedule;
            }
        }
        return null;
    }

    // Update an existing Schedule
    @Override
    public Schedule update(Schedule schedule) {
        String id = schedule.getScheduleId();
        Schedule oldSchedule = read(id);

        if(oldSchedule != null){
            scheduleList.remove(oldSchedule); // Remove old entry
            scheduleList.add(schedule);       // Add updated entry
            return schedule;
        }
        return null;
    }

    // Deletes a Schedule by ID
    @Override
    public boolean delete(String id) {
        Schedule scheduleToDelete = read(id);

        if(scheduleToDelete !=null){
            scheduleList.remove(scheduleToDelete);
            return true;
        }
        return false;
    }

    // Get all Admin objects
    @Override
    public List<Schedule> getAll() {
        return scheduleList;
    }
}



