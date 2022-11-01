package com.upc.apprelacionesallrest.model.oneToOne.bidirectional;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OWNER_ID", unique = true, nullable = false)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "owner")
    @JsonManagedReference//si permite el registo del Car
    private Car car;

}
