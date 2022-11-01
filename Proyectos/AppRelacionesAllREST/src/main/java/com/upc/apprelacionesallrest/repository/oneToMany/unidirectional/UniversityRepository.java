package com.upc.apprelacionesallrest.repository.oneToMany.unidirectional;

import com.upc.apprelacionesallrest.model.oneToMany.unidirectional.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}
