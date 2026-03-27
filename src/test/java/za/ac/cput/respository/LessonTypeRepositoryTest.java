/*
 * LessonTypeRepositoryTest.java
 * LessonTypeRepositoryTest class
 * Author: Rameez Karriem (222357320)
 * Date: 27 March 2026
 */

package za.ac.cput.respository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.LessonType;
import za.ac.cput.factory.LessonTypeFactory;
import za.ac.cput.repository.LessonTypeRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LessonTypeRepositoryTest {

    // Get singleton instance of repository
    private LessonTypeRepository lessonTypeRepository = LessonTypeRepository.getRepository();

    // Helper method to create a sample lessonType
    private LessonType createLessonType() {
        return LessonTypeFactory.createLessonType(
                "L01",
                "Code 8",
                200.00,
                60,
                "car"
        );
    }

    @Test
    @Order(1)
    void create() {
        LessonType lessonType = createLessonType();

        // Save lessonType to repository
        LessonType created = lessonTypeRepository.create(lessonType);

        // Check lessonType was created
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        LessonType lessonType = createLessonType();
        lessonTypeRepository.create(lessonType);

        // Retrieve lessonType by ID
        LessonType found = lessonTypeRepository.read(lessonType.getLessonId());

        // Check lessonType exists
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {
        LessonType lessonType = createLessonType();
        lessonTypeRepository.create(lessonType);

        // Modify existing lessonType
        LessonType updatedLessonType = new LessonType.Builder()
                .copy(lessonType)
                .setTypeName("Code 10")
                .build();

        // Update in repository
        LessonType updated = lessonTypeRepository.update(updatedLessonType);

        // Verify update worked
        assertNotNull(updated);
        assertEquals("Code 10", updated.getTypeName());
    }

    @Test
    @Order(4)
    void delete() {
        LessonType lessonType = createLessonType();
        lessonTypeRepository.create(lessonType);

        // Delete lessonType by ID
        boolean deleted = lessonTypeRepository.delete(lessonType.getLessonId());

        // Verify deletion was successful
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {

        // Add a lessonType to repository
        lessonTypeRepository.create(createLessonType());

        // Check repository is not empty
        assertFalse(lessonTypeRepository.getAll().isEmpty());
    }
}