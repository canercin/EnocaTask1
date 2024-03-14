package org.example.enocatask1.service.classes;

import org.example.enocatask1.dto.AddressRequestDTO;
import org.example.enocatask1.entities.Address;
import org.example.enocatask1.entities.User;
import org.example.enocatask1.repo.AddressRepo;
import org.example.enocatask1.service.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService implements IAddressService {
    private AddressRepo addressRepo;
    private UserService userService;

    @Autowired
    public AddressService(AddressRepo addressRepo, UserService userService) {
        this.addressRepo = addressRepo;
        this.userService = userService;
    }

    public void save(AddressRequestDTO address){
        User user = userService.findById(address.getUser_id());
        Address newAddress = new Address(address.getAddress(), user);
        addressRepo.save(newAddress);
    }

    public List<Address> findAll(){
        return addressRepo.findAll();
    }

    public Address findById(Long id){
        return addressRepo.findById(id).get();
    }

    public void update(AddressRequestDTO address){
        User user = addressRepo.findById(address.getAddress_id()).get().getUser();
        Address newAddress = new Address(address.getAddress_id(), address.getAddress(), user);
        addressRepo.save(newAddress);
    }

    public void delete(Long id){
        addressRepo.deleteById(id);
    }
}
