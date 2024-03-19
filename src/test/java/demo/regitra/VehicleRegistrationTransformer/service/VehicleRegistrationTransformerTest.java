package demo.regitra.VehicleRegistrationTransformer.service;

import demo.regitra.VehicleRegistrationTransformer.domain.TransformedRegistration;
import demo.regitra.VehicleRegistrationTransformer.domain.VehicleRegistration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class VehicleRegistrationTransformerTest {

    private VehicleRegistrationTransformerService transformer = new VehicleRegistrationTransformerService();

    @Test
    public void transformRegistrationDocuments() {
        List<VehicleRegistration> inputList = Arrays.asList(
                new VehicleRegistration("John", "Doe", null, "ABC123", LocalDate.now().plusDays(10)),
                new VehicleRegistration("Alice", "Smith", null, "XYZ789", LocalDate.now().plusDays(20)),
                new VehicleRegistration("Bob", "Johnson", null, "DEF456", LocalDate.now().minusDays(5)),
                new VehicleRegistration(null, null, "Vehicles Inc.", "AAA333", LocalDate.now().plusDays(20))
        );
        List<TransformedRegistration> expectedOutput = Arrays.asList(
                new TransformedRegistration("John Doe", "ABC123", 10), //refactored test data to reflect changes to int
                new TransformedRegistration("Alice Smith", "XYZ789", 20),
                new TransformedRegistration("Vehicles Inc.", "AAA333", 20)
        );

        List<TransformedRegistration> transformedList = transformer.transformRegistrationDocuments(inputList);

        if (transformedList.toString().equals(expectedOutput.toString())) { // Added toString() since object reference numbers will never be equal even if content is identical
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed. Expected: " + expectedOutput + ", Actual: " + transformedList);
        }

        Assertions.assertEquals(transformedList.toString(), expectedOutput.toString()); //if we want to avoid using toString() we need to override equals method in TransformedRegistration class
    }
}