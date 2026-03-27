
/*
 * BookingRepositoryTest.java
 * BookingRepositoryTest class
 * Author: Rameez Karriem (222357320)
 * Date: 27 March 2026
 */

package za.ac.cput.respository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.repository.BookingRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Test class for BookingRepository CRUD operations
public class BookingRepositoryTest {

    // Get singleton instance of repository
    private BookingRepository bookingRepository = BookingRepository.getRepository();

    // Helper method to create a sample booking
    private Booking createBooking() {
        return BookingFactory.createBooking(
                "B001",
                LocalDate.of(2026, 12, 25),
                "07:00",
                "open",
                "L001",
                "I001"
        );
    }

    @Test
    @Order(1)
    void create() {
        Booking booking = createBooking();

        // Save booking to repository
        Booking created = bookingRepository.create(booking);

        // Check booking was created
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Booking booking = createBooking();
        bookingRepository.create(booking);

        // Retrieve booking by ID
        Booking found = bookingRepository.read(booking.getBookingId());

        // Check booking exists
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {
        Booking booking = createBooking();
        bookingRepository.create(booking);

        // Modify existing booking
        Booking updatedBooking = new Booking.Builder()
                .copy(booking)
                .setStatus("closed")
                .build();

        // Update in repository
        Booking updated = bookingRepository.update(updatedBooking);

        // Verify update worked
        assertNotNull(updated);
        assertEquals("closed", updated.getStatus());
    }

    @Test
    @Order(4)
    void delete() {
        Booking booking = createBooking();
        bookingRepository.create(booking);

        // Delete booking by ID
        boolean deleted = bookingRepository.delete(booking.getBookingId());

        // Verify deletion was successful
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {

        // Add a booking to repository
        bookingRepository.create(createBooking());

        // Check repository is not empty
        assertFalse(bookingRepository.getAll().isEmpty());
    }
}