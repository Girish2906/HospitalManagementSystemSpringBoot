package com.codingshuttle.youtube.hospitalManagement2.entity;

import com.codingshuttle.youtube.hospitalManagement2.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false , unique = true , length = 50)
    private String policyNumber ;

    @Column(nullable = false , length = 100)
    private String provider ;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate validUntil ;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getPolicyNumber() {
//        return policyNumber;
//    }
//
//    public void setPolicyNumber(String policyNumber) {
//        this.policyNumber = policyNumber;
//    }
//
//    public String getProvider() {
//        return provider;
//    }
//
//    public void setProvider(String provider) {
//        this.provider = provider;
//    }
//
//    public LocalDate getValidUntil() {
//        return validUntil;
//    }
//
//    public void setValidUntil(LocalDate validUntil) {
//        this.validUntil = validUntil;
//    }
//
//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }

    // this is the inverse side
    @OneToOne(mappedBy = "insurance")
    private Patient patient ;



}
