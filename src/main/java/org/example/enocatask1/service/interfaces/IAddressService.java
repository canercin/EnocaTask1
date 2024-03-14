package org.example.enocatask1.service.interfaces;

import org.example.enocatask1.dto.AddressRequestDTO;
import org.example.enocatask1.entities.Address;

import java.util.List;

public interface IAddressService {
    void save(AddressRequestDTO address);
    List<Address> findAll();
    Address findById(Long id);
    void update(AddressRequestDTO address);
    void delete(Long id);
}
