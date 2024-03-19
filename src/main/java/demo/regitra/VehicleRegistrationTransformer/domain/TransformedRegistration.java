package demo.regitra.VehicleRegistrationTransformer.domain;

import io.swagger.v3.oas.annotations.media.Schema;

public class TransformedRegistration { //fixed typo
//    private static final String SERVICE_NAME = "VEHICLE_DECLARATION"; //fixed typos + removed since this static field was never used

    @Schema(description = "Entity owning the vehicle", example = "John Doe")
    private String owner;
    @Schema(description = "State issues plate number for the vehicle", example = "ABC123")
    private String licensePlateNumber; //refactored to reflect data content
    @Schema(description = "Days remaining before license to use the vehicle will be revoked", example = "120")
    private int remainingDaysUntilExpiration; //refactored since registration is unlikely to be valid for more than 5 883 516 years so we are safe to use int

    // Constructor
    public TransformedRegistration(String fullName, String plateNumber, int remainingDaysUntilExpiration) {
        this.owner = fullName;
        this.licensePlateNumber = plateNumber;
        this.remainingDaysUntilExpiration = remainingDaysUntilExpiration;
    }

    // Getters
    public String getOwner() {
        return owner;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public int getRemainingDaysUntilExpiration() {
        return remainingDaysUntilExpiration;
    }

    @Override
    public String toString() { //generated this for test purposes TODO remove before commit
        return "TransformedRegistration{" +
                "owner='" + owner + '\'' +
                ", licensePlateNumber='" + licensePlateNumber + '\'' +
                ", remainingDaysUntilExpiration=" + remainingDaysUntilExpiration +
                '}';
    }
}