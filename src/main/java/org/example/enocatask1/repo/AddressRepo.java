package org.example.enocatask1.repo;

import org.example.enocatask1.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
