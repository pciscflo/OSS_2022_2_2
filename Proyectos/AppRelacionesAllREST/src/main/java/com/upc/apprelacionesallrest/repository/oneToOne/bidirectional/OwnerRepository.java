package com.upc.apprelacionesallrest.repository.oneToOne.bidirectional;

import com.upc.apprelacionesallrest.model.oneToOne.bidirectional.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
