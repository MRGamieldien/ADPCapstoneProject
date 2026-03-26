/* VehicleFactory.java
   Factory class for creating Vehicle objects
   Author: Redah Gamieldien (222641681)
   Date: 26 March 2026
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.Helper;

/**
 * A factory class that creates Vehicle objects, ensuring each one is properly set up and ready to use.
 */


public class VehicleFactory {

    /**
     * Creates and returns a Vehicle with all attributes.
     */
    public static Vehicle createVehicle(String vehicleID,
                                        String model,
                                        String regNumber,
                                        String transmissionType,
                                        boolean isAvailable) {


        if (Helper.isNullOrEmpty(vehicleID) ||
                Helper.isNullOrEmpty(model) ||
                Helper.isNullOrEmpty(regNumber) ||
                Helper.isNullOrEmpty(transmissionType)) {
            return null;
        }


        return new Vehicle.Builder()
                .setVehicleID(vehicleID)
                .setModel(model)
                .setRegNumber(regNumber)
                .setTransmissionType(transmissionType)
                .setIsAvailable(isAvailable)
                .build();

    }
}
