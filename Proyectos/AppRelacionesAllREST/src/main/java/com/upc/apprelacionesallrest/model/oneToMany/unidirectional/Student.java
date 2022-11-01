package com.upc.apprelacionesallrest.model.oneToMany.unidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String indexNumber;

    public Student() {
    }

}
