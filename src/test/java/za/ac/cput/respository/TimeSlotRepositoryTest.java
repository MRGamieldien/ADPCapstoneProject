/*
 * TimeSlotRepositoryTest.java
 * TimeSlotRepositoryTest class
 * Author: Redah Gamieldien (222641681)
 * Date: 27 March 2026
 */

package za.ac.cput.respository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.TimeSlot;
import za.ac.cput.factory.TimeSlotFactory;
import za.ac.cput.repository.TimeSlotRepository;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Test class for TimeSlotRepository CRUD operations
public class TimeSlotRepositoryTest {

    // Get singleton instance of repository
    private TimeSlotRepository timeSlotRepository = TimeSlotRepository.getRepository();

    // Helper method to create a sample time slot
    private TimeSlot createTimeSlot() {
        return TimeSlotFactory.createTimeSlot(
                "TS001",
                LocalTime.of(9, 0),
                LocalTime.of(10, 0),
                LocalDate.of(2026, 3, 27),
                false
        );
    }

    @Test
    @Order(1)
    void create() {
        TimeSlot timeSlot = createTimeSlot();

        // Save time slot to repository
        TimeSlot created = timeSlotRepository.create(timeSlot);

        // Check time slot was created
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        TimeSlot timeSlot = createTimeSlot();
        timeSlotRepository.create(timeSlot);

        // Retrieve time slot by ID
        TimeSlot found = timeSlotRepository.read(timeSlot.getSlotId());

        // Check time slot exists
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {
        TimeSlot timeSlot = createTimeSlot();
        timeSlotRepository.create(timeSlot);

        // Modify existing time slot (change end time and booked status only)
        TimeSlot updatedTimeSlot = new TimeSlot.Builder()
                .copy(timeSlot)
                .setEndTime(LocalTime.of(11, 0))
                .setIsBooked(true)
                .build();

        // Update in repository
        TimeSlot updated = timeSlotRepository.update(updatedTimeSlot);

        // Verify update worked
        assertNotNull(updated);
        assertEquals(LocalTime.of(11, 0), updated.getEndTime());
        assertTrue(updated.isBooked());
    }

    @Test
    @Order(4)
    void delete() {
        TimeSlot timeSlot = createTimeSlot();
        timeSlotRepository.create(timeSlot);

        // Delete time slot by ID
        boolean deleted = timeSlotRepository.delete(timeSlot.getSlotId());

        // Verify deletion was successful
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {

        // Add a time slot to repository
        timeSlotRepository.create(createTimeSlot());

        // Check repository is not empty
        assertFalse(timeSlotRepository.getAll().isEmpty());
    }
}