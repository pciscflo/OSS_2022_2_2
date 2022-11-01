package com.upc.apprelacionesallrest.repository.oneToMany.bidirectional;

import com.upc.apprelacionesallrest.model.oneToMany.bidirectional.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
