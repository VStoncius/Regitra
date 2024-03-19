package demo.regitra.VehicleRegistrationTransformer.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public class VehicleRegistration { //refactored typo

  @Schema(description = "First name of the owner", example = "John")
  private String ownerFirstName;
  @Schema(description = "Last name of the owner", example = "Doe")
  private String ownerLastName;
  @Schema(description = "Name of business owning the vehicle", example = "Big Bad Inc.")
  private String ownerLegalName;
  @Schema(description = "State issues plate number for the vehicle", example = "ABC123")
  private String vehiclePlateNumber;
  @Schema(description = "Date of issued license expiring", example = "2026-01-01")
  private LocalDate expiryDate;
//  private LocalDate birthDay; This value is irrelevant and should be removed

  // Constructor
  public VehicleRegistration(String ownerFirstName, String ownerLastName, String ownerLegalName, String plateNumber, LocalDate expiryDate) {
    this.ownerFirstName = ownerFirstName;
    this.ownerLastName = ownerLastName;
    this.ownerLegalName = ownerLegalName;
    this.vehiclePlateNumber = plateNumber; //refactored to reflect content more accurately
    this.expiryDate = expiryDate;
  }

  // Getters
  public String getOwnerFirstName() {
    return ownerFirstName;
  } //fixed typo

  public String getOwnerLastName() {
    return ownerLastName;
  }

  public String getOwnerLegalName() {
    return ownerLegalName;
  }

  public String getVehiclePlateNumber() {
    return vehiclePlateNumber;
  }

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  @Override
  public String toString() { //generated this for test purposes TODO remove before commit
    return "VehicleRegistration{" +
            "ownerFirstName='" + ownerFirstName + '\'' +
            ", ownerLastName='" + ownerLastName + '\'' +
            ", ownerLegalName='" + ownerLegalName + '\'' +
            ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
            ", expiryDate=" + expiryDate +
            '}';
  }
}