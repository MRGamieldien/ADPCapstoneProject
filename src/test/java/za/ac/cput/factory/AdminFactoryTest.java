/*
 * AdminFactoryTest.java
 * AdminFactoryTest class for testing Admin creation
 * Author: Ethan Williams (221454780)
 * Date: 26 March 2026
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Admin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// Enables tests to run in order using @Order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminFactoryTest {

    // Test 1: Create a valid admin with all fields
    @Test
    @Order(1)  // Runs first
    public void testCreateAdmin() {
        Admin admin = AdminFactory.createAdmin(
                "UA01",                // adminId
                "Marketing Department", // department
                2,                     // accessLevel
                "U001"                 // userId
        );
        assertNotNull(admin);  // Verify admin was created
    }

    // Test 2: Create an admin with empty department
    @Test
    @Order(2)  // Runs second
    public void testCreateAdminWithEmptyDepartment() {
        Admin admin = AdminFactory.createAdmin(
                "UA01",    // adminId
                "",        // empty department
                2,         // accessLevel
                "U001"     // userId
        );
        assertNull(admin);  // Verify admin was NOT created (empty department should fail)
    }
}
