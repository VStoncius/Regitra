package demo.regitra.VehicleRegistrationTransformer.controllers;

import demo.regitra.VehicleRegistrationTransformer.domain.TransformedRegistration;
import demo.regitra.VehicleRegistrationTransformer.domain.VehicleRegistration;
import demo.regitra.VehicleRegistrationTransformer.service.VehicleRegistrationTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class VehicleRegistrationController {

    @Autowired
    private VehicleRegistrationTransformerService transformerService;

    @PostMapping("/transform")
    public ResponseEntity<List<TransformedRegistration>> transformJSON(@RequestBody List<VehicleRegistration> vehicleList) {
        return new ResponseEntity<List<TransformedRegistration>>(transformerService.transformRegistrationDocuments(vehicleList), HttpStatus.OK);
    }
}
