package com.upc.apprelacionesallrest.model.oneToMany.unidirectional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "university_id")
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "university_id",referencedColumnName="university_id")
    private List<Student> students = new ArrayList<>();

    public University() {
    }

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
