/*
 * LearnerRepositoryTest.java
 * LearnerRepositoryTest class
 * Author: Ethan Williams (221454780)
 * Date: 27 March 2026
 */
package za.ac.cput.respository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Learner;
import za.ac.cput.factory.LearnerFactory;
import za.ac.cput.repository.LearnerRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Test class for LearnerRepository CRUD operations
public class LearnerRepositoryTest {

    // Get singleton instance of repository
    private LearnerRepository learnerRepository = LearnerRepository.getRepository();

    // Helper method to create a sample learner
    private Learner createLearner(){
        return LearnerFactory.createLearner(
                "US20124",
                "012457158",
                "Manual",
                LocalDate.of(2020,02,13),
                "UA001"
        );
    }

    @Test
    @Order(1)
    void create(){
        Learner learner = createLearner();

        // Save learner to repository
        Learner created = learnerRepository.create(learner);

        // Check learner was created
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read(){
        Learner learner = createLearner();
        learnerRepository.create(learner);

        // Retrieve learner by ID
        Learner found = learnerRepository.read(learner.getLearnerId());

        // Check learner exists
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {
        Learner learner = createLearner();
        learnerRepository.create(learner); // ensure it exists before updating

        // Modify existing learner
        Learner updatedLearner = new Learner.Builder()
                .copy(learner)
                .setLicenseType("Automatic")
                .build();

        // Update in repository
        Learner updated = learnerRepository.update(updatedLearner);

        // Verify update worked
        assertNotNull(updated);
        assertEquals("Automatic", updated.getLicenseType());
    }

    @Test
    @Order(4)
    void delete(){
        Learner learner = createLearner();
        learnerRepository.create(learner);

        // Delete learner by ID
        boolean deleted = learnerRepository.delete(learner.getLearnerId());

        // Verify deletion was successful
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll(){
        // Add a learner to repository
        learnerRepository.create(createLearner());

        // Check repository is not empty
        assertFalse(learnerRepository.getAll().isEmpty());
    }
}