package com.codingshuttle.youtube.hospitalManagement2.entity;

import com.codingshuttle.youtube.hospitalManagement2.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
//@ToString
@Table(
        name = "patient_tlb" ,
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email" , columnNames = {"email"}) ,
                @UniqueConstraint(name = "unique_patient_name_birthDate" , columnNames = {"name" , "birthDate"})
        } ,
        indexes = {
                @Index(name = "idx_patient_birth_date" , columnList = "birthDate")
        }
)


public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column (name = "patient_name" , nullable = false)
    private String name ;
    @Column(unique = true , nullable = false)
    private String email ;
    private String gender ;
    private LocalDate birthDate ;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt ;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup ;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

//    this is the owning side
    @OneToOne(cascade = { CascadeType.ALL } , orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance ;


//    @ToString.Exclude
    @OneToMany(mappedBy = "patient" , cascade = {CascadeType.REMOVE} , orphanRemoval = true , fetch = FetchType.EAGER)
    private List<Appointment> appointments = new ArrayList<>();

}