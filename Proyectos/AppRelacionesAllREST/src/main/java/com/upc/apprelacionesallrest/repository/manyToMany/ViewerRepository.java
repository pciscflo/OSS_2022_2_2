package com.upc.apprelacionesallrest.repository.manyToMany;

import com.upc.apprelacionesallrest.model.manyToMany.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewerRepository extends JpaRepository<Viewer, Long> {
}
