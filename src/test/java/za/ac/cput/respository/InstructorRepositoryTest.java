/* InstructorRepositoryTest.java
InstructorRepositoryTest model class
Author: Qaasim Isaacs (222544422)
Date: 27 March 2026
*/
package za.ac.cput.respository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Instructor;
import za.ac.cput.repository.InstructorRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Test class for InstructorRepository CRUD operations
public class InstructorRepositoryTest {

    // Get singleton instance of repository
    private InstructorRepository instructorRepository = InstructorRepository.getRepository();

    // Helper method to create a sample instructor
    private Instructor createInstructor() {
        return new Instructor.Builder()
                .setInstructorId("I001")
                .setEmployeeCode("EMP001")
                .setSpecialisation("Java Programming")
                .setRating(4.5)
                .setUserId("U001")
                .build();
    }

    @Test
    @Order(1)
    void create() {
        Instructor instructor = createInstructor();

        // Save instructor to repository
        Instructor created = instructorRepository.create(instructor);

        // Check instructor was created
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Instructor instructor = createInstructor();
        instructorRepository.create(instructor);

        // Retrieve instructor by ID
        Instructor found = instructorRepository.read(instructor.getInstructorId());

        // Check instructor exists
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {
        Instructor instructor = createInstructor();
        instructorRepository.create(instructor);

        // Modify existing instructor
        Instructor updatedInstructor = new Instructor.Builder()
                .copy(instructor)
                .setSpecialisation("Advanced Java")
                .build();

        // Update in repository
        Instructor updated = instructorRepository.update(updatedInstructor);

        // Verify update worked
        assertNotNull(updated);
        assertEquals("Advanced Java", updated.getSpecialisation());
    }

    @Test
    @Order(4)
    void delete() {
        Instructor instructor = createInstructor();
        instructorRepository.create(instructor);

        // Delete instructor by ID
        boolean deleted = instructorRepository.delete(instructor.getInstructorId());

        // Verify deletion was successful
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {

        // Add an instructor to repository
        instructorRepository.create(createInstructor());

        // Check repository is not empty
        assertFalse(instructorRepository.getAll().isEmpty());
    }
}
