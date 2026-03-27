/*
 * BookingFactoryTest.java
 * BookingFactoryTest class
 * Author: Rameez Karriem (222357320)
 * Date: 26 March 2026
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingFactoryTest {

    @Test
    @Order(1)
    void createBooking() {
        // Create LocalDate and timeSlot as String
        LocalDate bookingDate = LocalDate.of(2026, 12, 25);
        String timeSlot = "07:00";

        Booking booking = BookingFactory.createBooking(
                "222357320",
                bookingDate,
                timeSlot,
                "accepted",
                "22355674",
                "555666999"
        );

        assertNotNull(booking); // pass if all fields are not null
    }

    @Test
    @Order(2)
    void testCreateBookingWithEmptyFields() {
        LocalDate bookingDate = LocalDate.of(2026, 12, 25);
        String timeSlot = "07:00";

        // Test with empty bookingId
        Booking booking1 = BookingFactory.createBooking(
                "", // empty bookingId
                bookingDate,
                timeSlot,
                "accepted",
                "22355674",
                "555666999"
        );
        assertNull(booking1); // pass if bookingId is empty/null

        // Test with empty timeSlot
        Booking booking2 = BookingFactory.createBooking(
                "222357320",
                bookingDate,
                "", // empty timeSlot
                "accepted",
                "22355674",
                "555666999"
        );
        assertNull(booking2); // pass if timeSlot is empty/null

        // Test with empty status
        Booking booking3 = BookingFactory.createBooking(
                "222357320",
                bookingDate,
                timeSlot,
                "", // empty status
                "22355674",
                "555666999"
        );
        assertNull(booking3); // pass if status is empty/null

        // Test with empty learnerId
        Booking booking4 = BookingFactory.createBooking(
                "222357320",
                bookingDate,
                timeSlot,
                "accepted",
                "", // empty learnerId
                "555666999"
        );
        assertNull(booking4); // pass if learnerId is empty/null

        // Test with empty instructorId
        Booking booking5 = BookingFactory.createBooking(
                "222357320",
                bookingDate,
                timeSlot,
                "accepted",
                "22355674",
                "" // empty instructorId
        );
        assertNull(booking5); // pass if instructorId is empty/null
    }

    @Test
    @Order(3)
    void testCreateBookingWithNullBookingDate() {
        String timeSlot = "07:00";

        Booking booking = BookingFactory.createBooking(
                "222357320",
                null, // null bookingDate
                timeSlot,
                "accepted",
                "22355674",
                "555666999"
        );

        assertNull(booking); // pass if bookingDate is null
    }

    @Test
    @Order(4)
    void testCreateBookingWithNullTimeSlot() {
        LocalDate bookingDate = LocalDate.of(2026, 12, 25);

        Booking booking = BookingFactory.createBooking(
                "222357320",
                bookingDate,
                null, // null timeSlot
                "accepted",
                "22355674",
                "555666999"
        );

        assertNull(booking); // pass if timeSlot is null
    }

    @Test
    @Order(5)
    void testCreateBookingWithAllValidFields() {
        LocalDate bookingDate = LocalDate.of(2026, 12, 25);
        String timeSlot = "07:00";

        Booking booking = BookingFactory.createBooking(
                "222357320",
                bookingDate,
                timeSlot,
                "accepted",
                "22355674",
                "555666999"
        );

        assertNotNull(booking);
        assertEquals("222357320", booking.getBookingId());
        assertEquals(bookingDate, booking.getBookingDate());
        assertEquals(timeSlot, booking.getTimeSlot());
        assertEquals("accepted", booking.getStatus());
        assertEquals("22355674", booking.getLearnerId());
        assertEquals("555666999", booking.getInstructorId());
    }
}
