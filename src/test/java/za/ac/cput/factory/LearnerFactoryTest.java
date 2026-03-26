/*
 * LearnerFactoryTest.java
 * LearnerFactoryTest class
 * Author: Ethan Williams(221454780)
 * Date: 26 March 2026
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Learner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// Enables tests to run in order using @Order annotations
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LearnerFactoryTest {

    // Test 1: Create a valid learner with all fields
    @Test
    @Order(1)  // Runs first
    public void testCreateLearner(){
        Learner learner = LearnerFactory.createLearner(
                "UT01",           // learnerId
                "ZA22145750",     // learnerNumber
                "Manual",         // licenseType
                LocalDate.of(2025, 2, 25),  // dateRegistered
                "U001"            // userId
        );
        assertNotNull(learner);  // Verify learner was created
    }

    // Test 2: Create a learner with empty learner number
    @Test
    @Order(2)  // Runs second
    public void testCreateLearnerWithEmptyLearnerNumber(){
        Learner learner = LearnerFactory.createLearner(
                "UT01",           // learnerId
                "",               // learnerNumber (empty)
                "Manual",         // licenseType
                LocalDate.of(2025, 2, 25),  // dateRegistered
                "U001"            // userId
        );
        assertNull(learner);  // Verify learner was NOT created (empty field should fail)
    }
}
