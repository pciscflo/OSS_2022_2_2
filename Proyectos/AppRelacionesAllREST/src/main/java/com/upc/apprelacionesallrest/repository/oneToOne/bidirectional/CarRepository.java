package com.upc.apprelacionesallrest.repository.oneToOne.bidirectional;

import com.upc.apprelacionesallrest.model.oneToOne.bidirectional.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
