package org.example.enocatask1.rest;

import org.example.enocatask1.dto.AddressRequestDTO;
import org.example.enocatask1.entities.Address;
import org.example.enocatask1.service.classes.AddressService;
import org.example.enocatask1.service.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressAPI {

    private IAddressService addressService;

    @Autowired
    public AddressAPI(AddressService addressService) {
        this.addressService = addressService;
    }

    /*
     * passed
     */
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody AddressRequestDTO address){
        addressService.save(address);
        return new ResponseEntity<>(address.toString() + " added", HttpStatus.OK);
    }

    /*
     * passed
     */
    @GetMapping
    public List<Address> findAll() {
        return addressService.findAll();
    }

    /*
     * passed
     */
    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody AddressRequestDTO address){
        this.addressService.update(address);
        return new ResponseEntity<>(address.toString() + "güncellendi", HttpStatus.OK);
    }

    /*
     * passed
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        addressService.delete(id);
        return new ResponseEntity<>(id + " id'li adres silindi", HttpStatus.OK);
    }
}
