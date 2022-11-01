package com.upc.apprelacionesallrest.model.oneToMany.bidirectional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonManagedReference("cart_items")
    private List<Item> items = new ArrayList<>();

}
