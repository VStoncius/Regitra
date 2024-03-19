package demo.regitra.VehicleRegistrationTransformer.service;

import demo.regitra.VehicleRegistrationTransformer.domain.TransformedRegistration;
import demo.regitra.VehicleRegistrationTransformer.domain.VehicleRegistration;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VehicleRegistrationTransformerService {

    /**
     * Metodas turėtų atrinkti tik galiojančias registracijas bei jas transformuoti į naują objektą, kur
     * ownerFN - asmens vardas ir pavardė arba įmonės pavadinimas
     * vehicleModel - automobilio modelis didžiosiomis raidėmis (priimu kaip automobilio valstybini numeri)
     * remainingDaysUntilExpiration - registracijos galiojimo laikas dienomis
     * <p>
     * Pastaba: galima pervadinti objektus, atributus į labiau atspindinčius prasmę ar "naming'o" praktikas
     */
    public List<TransformedRegistration> transformRegistrationDocuments(List<VehicleRegistration> registrations) {
        return registrations
                .stream()
                .filter(vehReg -> vehReg.getExpiryDate().isAfter(LocalDate.now()))
                .map(vehicleReg -> convertValidVehicleRegistration(vehicleReg))
                .toList();
    }

    private TransformedRegistration convertValidVehicleRegistration(VehicleRegistration vehicleRegistration) {
        /**
         *   This method will prioritise Business name over Individual's name.
         *   Example:"ownerFirstName": "John","ownerLastName": "Doe","ownerLegalName": "Big Bad Inc." fullOwnerName will be set as: "Big Bad Inc."
         */
        return new TransformedRegistration(
                Objects.requireNonNullElse(vehicleRegistration.getOwnerLegalName(), vehicleRegistration.getOwnerFirstName() + " " + vehicleRegistration.getOwnerLastName()),
                vehicleRegistration.getVehiclePlateNumber(),
                LocalDate.now().until(vehicleRegistration.getExpiryDate()).getDays()
        );
    }
}