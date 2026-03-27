/*
 * AdminRepositoryTest.java
 * AdminRepositoryTest class
 * Author: Ethan Williams (221454780)
 * Date: 27 March 2026
 */

package za.ac.cput.respository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.repository.AdminRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

// Test class for AdminRepository CRUD operations
public class AdminRepositoryTest {

    // Get singleton instance of repository
    private AdminRepository adminRepository = AdminRepository.getRepository();

    // Helper method to create a sample admin
    private Admin createAdmin() {
        return AdminFactory.createAdmin(
                "UA01",
                "Marketing Department",
                5,
                "U001"
        );
    }

    @Test
    @Order(1)
    void create() {
        Admin admin = createAdmin();

        // Save admin to repository
        Admin created = adminRepository.create(admin);

        // Check admin was created
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Admin admin = createAdmin();
        adminRepository.create(admin);

        // Retrieve admin by ID
        Admin found = adminRepository.read(admin.getAdminId());

        // Check admin exists
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {
        Admin admin = createAdmin();
        adminRepository.create(admin);

        // Modify existing admin (change department only)
        Admin updatedAdmin = new Admin.Builder()
                .copy(admin)
                .setDepartment("HR Department")
                .build();

        // Update in repository
        Admin updated = adminRepository.update(updatedAdmin);

        // Verify update worked
        assertNotNull(updated);
        assertEquals("HR Department", updated.getDepartment());
    }

    @Test
    @Order(4)
    void delete() {
        Admin admin = createAdmin();
        adminRepository.create(admin);

        // Delete admin by ID
        boolean deleted = adminRepository.delete(admin.getAdminId());

        // Verify deletion was successful
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {

        // Add an admin to repository
        adminRepository.create(createAdmin());

        // Check repository is not empty
        assertFalse(adminRepository.getAll().isEmpty());
    }
}