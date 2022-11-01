package com.upc.apprelacionesallrest.repository.manyToMany;

import com.upc.apprelacionesallrest.model.manyToMany.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamRepository extends JpaRepository<Stream, Long> {
}
