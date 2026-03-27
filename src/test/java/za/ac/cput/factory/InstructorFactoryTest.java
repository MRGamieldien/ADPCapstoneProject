/*
 * InstructorFactoryTest.java
 * InstructorFactoryTest class
 * Author: Qaasim Isaacs(222544422)
 * Date: 26 March 2026
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Instructor;

import static org.junit.jupiter.api.Assertions.*;

// Enables tests to run in order using @Order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class InstructorFactoryTest {

    @Test
    @Order(1)
    public void testCreateInstructor() {
        Instructor instructor = InstructorFactory.createInstructor(
                "I001",
                "EMP1",
                "Driving",
                4.5,
                "U001"
        );

        assertNotNull(instructor); // Pass if all fields are valid
    }

    @Test
    @Order(2)
    public void testCreateInstructorWithEmptySpecialisation() {

        Instructor instructor = InstructorFactory.createInstructor(
                "I002",
                "EMP2",
                "",   // empty specialization
                4.0,
                "U002"
        );

        assertNull(instructor); // Pass if validation returns null
    }

    @Test
    @Order(3)
    public void testCreateInstructorWithInvalidRating() {

        Instructor instructor = InstructorFactory.createInstructor(
                "I003",
                "EMP4",
                "Theory",
                6.0,  // invalid rating (>5)
                "U003"
        );

        assertNull(instructor); // Pass if rating validation fails
    }

    @Test
    @Order(4)
    public void testCreateInstructorWithNullUserId() {

        Instructor instructor = InstructorFactory.createInstructor(
                "I004",
                "EMP4",
                "Practical",
                3.5,
                ""  // userId is null
        );

        assertNull(instructor); // Pass if userId validation fails
    }
}
