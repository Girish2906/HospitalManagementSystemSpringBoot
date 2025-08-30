package com.codingshuttle.youtube.hospitalManagement2.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ConditionalOnIssuerLocationJwtDecoder;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false , unique = true , length = 100)
    private String name ;

    @OneToOne
    private Doctor headDoctor ;

    @ManyToMany
    @JoinTable(
            name = "my_dpt_doctors" ,
            joinColumns = @JoinColumn(name = "dpt_id") ,
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private Set<Doctor> doctors = new HashSet<>() ;


}