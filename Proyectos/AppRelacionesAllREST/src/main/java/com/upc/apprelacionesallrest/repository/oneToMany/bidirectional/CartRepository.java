package com.upc.apprelacionesallrest.repository.oneToMany.bidirectional;

import com.upc.apprelacionesallrest.model.oneToMany.bidirectional.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
