package com.upc.apprelacionesallrest.repository.oneToOne.unidirectional;

import com.upc.apprelacionesallrest.model.oneToOne.unidirectional.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
