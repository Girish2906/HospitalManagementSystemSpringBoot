package com.codingshuttle.youtube.hospitalManagement2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false , length = 100)
    private String name ;

    @Column(length = 100)
    private String specialization ;

    @Column(nullable = false , unique = false , length = 100)
    private String email ;

    @ManyToMany(mappedBy = "doctors" , fetch = FetchType.EAGER )
    private Set<Department> departments = new HashSet<>() ;

    @OneToMany(mappedBy = "doctor" , fetch = FetchType.EAGER)
    private List<Appointment> appointments = new ArrayList<>() ;
}
