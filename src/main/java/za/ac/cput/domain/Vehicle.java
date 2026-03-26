/* Vehicle.java
   Vehicle model class
   Author: Redah Gamieldien (222641681)
   Date: 25 March 2025
 */

package za.ac.cput.domain;

/**
 * Represents a vehicle available for driving lessons.
 */
public class Vehicle {
    private int vehicleID;
    private String model;
    private String regNumber;
    private String transmissionType;
    private boolean isAvailable;


    //Default constructor.
    public Vehicle() {
    }

    //Private constructor for Builder pattern.
    private Vehicle(Builder builder){
        this.vehicleID = builder.vehicleID;
        this.model = builder.model;
        this.regNumber = builder.regNumber;
        this.transmissionType = builder.transmissionType;
        this.isAvailable = builder.isAvailable;
    }

    /** Returns the vehicle's unique ID. */
    public int getVehicleID() {return vehicleID;}

    /** Returns the vehicle model name. */
    public String getModel() {return model;}

    /** Returns the registration number. */
    public String getRegNumber() {return regNumber;}

    /** Returns the transmission type (e.g. manual, automatic). */
    public String getTransmissionType() {return transmissionType;}

    /** Returns true if the vehicle is available for booking. */
    public boolean isAvailable() {return isAvailable;}

    /**
     * Builder for constructing Vehicle instances step by step.
     */
    public static class Builder {
        private int vehicleID;
        private String model;
        private String regNumber;
        private String transmissionType;
        private boolean isAvailable;

        public Builder setVehicleID(int vehicleID) {
            this.vehicleID = vehicleID;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setRegNumber(String regNumber) {
            this.regNumber = regNumber;
            return this;
        }

        public Builder setTransmissionType(String transmissionType){
            this.transmissionType = transmissionType;
            return this;
        }

        public Builder setIsAvailable(boolean isAvailable){
            this.isAvailable = isAvailable;
            return this;
        }

        public Builder copy(Vehicle vehicle) {
            this.vehicleID = vehicle.getVehicleID();
            this.model = vehicle.getModel();
            this.regNumber = vehicle.getRegNumber();
            this.transmissionType = vehicle.getTransmissionType();
            this.isAvailable = vehicle.isAvailable();
            return this;
        }


        // builds the vehicle object from the Builder
        public Vehicle build() {
            return new Vehicle(this);
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", model='" + model + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

