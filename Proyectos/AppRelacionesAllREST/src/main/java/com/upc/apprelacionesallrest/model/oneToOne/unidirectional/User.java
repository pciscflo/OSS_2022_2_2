package com.upc.apprelacionesallrest.model.oneToOne.unidirectional;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="t_user")
@Data
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_Id")
    private Address address;

}
