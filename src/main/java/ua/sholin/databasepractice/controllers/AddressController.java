package ua.sholin.databasepractice.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.sholin.databasepractice.models.Address;
import ua.sholin.databasepractice.service.AddressService;

import java.util.List;


@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Address>> getAddresses() {
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable long id) {
        return new ResponseEntity<>(addressService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@Valid @RequestBody Address address) {
        return new ResponseEntity<>(addressService.createAddress(address), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> editAddress(@PathVariable long id,
                                               @Valid @RequestBody
                                                       Address address) {
        return new ResponseEntity<>(addressService.edit(id, address),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable long id) {
        addressService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
