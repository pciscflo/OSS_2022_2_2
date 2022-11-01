package com.upc.apprelacionesallrest.repository.oneToOne.unidirectional;


import com.upc.apprelacionesallrest.model.oneToOne.unidirectional.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
