/*
 * VehicleRepository.java
 * VehicleRepository class - handles CRUD operations for Vehicle objects
 * Author: Redah Gamieldien (222641681)
 * Date: 27 March 2026
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements IRepository<Vehicle, String> {

    // Singleton instance of VehicleRepository
    public static VehicleRepository repository = null;

    // List to store Vehicle objects
    private List<Vehicle> vehicleList;

    // Private constructor to prevent external instantiation
    private VehicleRepository() {
        vehicleList = new ArrayList<>();
    }

    // Method to get the singleton instance of VehicleRepository
    public static VehicleRepository getRepository() {
        if (repository == null) {
            repository = new VehicleRepository();
        }
        return repository;
    }

    // Create a new Vehicle and add to the list
    @Override
    public Vehicle create(Vehicle vehicle) {
        boolean success = vehicleList.add(vehicle);
        if (success) {
            return vehicle;
        }
        return null;
    }

    // Read a Vehicle by its ID
    @Override
    public Vehicle read(String vehicleID) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getVehicleID().equals(vehicleID)) {
                return vehicle;
            }
        }
        return null;
    }

    // Update an existing Vehicle
    @Override
    public Vehicle update(Vehicle vehicle) {
        String id = vehicle.getVehicleID();
        Vehicle oldVehicle = read(id);

        if (oldVehicle != null) {
            vehicleList.remove(oldVehicle); // Remove old entry
            vehicleList.add(vehicle);       // Add updated entry
            return vehicle;
        }
        return null;
    }

    // Delete a Vehicle by ID
    @Override
    public boolean delete(String id) {
        Vehicle vehicleToDelete = read(id);

        if (vehicleToDelete != null) {
            vehicleList.remove(vehicleToDelete);
            return true;
        }
        return false;
    }

    // Get all Vehicle objects
    @Override
    public List<Vehicle> getAll() {
        return vehicleList;
    }
}
