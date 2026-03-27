/*
 * VehicleRepositoryTest.java
 * VehicleRepositoryTest class
 * Author: Redah Gamieldien (222641681)
 * Date: 27 March 2026
 */

package za.ac.cput.respository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;
import za.ac.cput.repository.VehicleRepository;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// Test class for VehicleRepository CRUD operations
public class VehicleRepositoryTest {

    // Get singleton instance of repository
    private VehicleRepository vehicleRepository = VehicleRepository.getRepository();

    // Helper method to create a sample vehicle
    private Vehicle createVehicle() {
        return VehicleFactory.createVehicle(
                "V001",
                "Toyota Corolla",
                "CAA 252-368",
                "Manual",
                true
        );
    }

    @Test
    @Order(1)
    void create() {
        Vehicle vehicle = createVehicle();

        // Save vehicle to repository
        Vehicle created = vehicleRepository.create(vehicle);

        // Check vehicle was created
        assertNotNull(created);
    }

    @Test
    @Order(2)
    void read() {
        Vehicle vehicle = createVehicle();
        vehicleRepository.create(vehicle);

        // Retrieve vehicle by ID
        Vehicle found = vehicleRepository.read(vehicle.getVehicleID());

        // Check vehicle exists
        assertNotNull(found);
    }

    @Test
    @Order(3)
    void update() {
        Vehicle vehicle = createVehicle();
        vehicleRepository.create(vehicle);

        // Modify existing vehicle (change model and transmission only)
        Vehicle updatedVehicle = new Vehicle.Builder()
                .copy(vehicle)
                .setModel("Toyota Yaris")
                .setTransmissionType("Automatic")
                .build();

        // Update in repository
        Vehicle updated = vehicleRepository.update(updatedVehicle);

        // Verify update worked
        assertNotNull(updated);
        assertEquals("Toyota Yaris", updated.getModel());
        assertEquals("Automatic", updated.getTransmissionType());
    }

    @Test
    @Order(4)
    void delete() {
        Vehicle vehicle = createVehicle();
        vehicleRepository.create(vehicle);

        // Delete vehicle by ID
        boolean deleted = vehicleRepository.delete(vehicle.getVehicleID());

        // Verify deletion was successful
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    void getAll() {

        // Add a vehicle to repository
        vehicleRepository.create(createVehicle());

        // Check repository is not empty
        assertFalse(vehicleRepository.getAll().isEmpty());
    }
}