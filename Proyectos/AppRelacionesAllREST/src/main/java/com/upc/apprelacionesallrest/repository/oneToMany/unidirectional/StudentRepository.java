package com.upc.apprelacionesallrest.repository.oneToMany.unidirectional;

import com.upc.apprelacionesallrest.model.oneToMany.unidirectional.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
