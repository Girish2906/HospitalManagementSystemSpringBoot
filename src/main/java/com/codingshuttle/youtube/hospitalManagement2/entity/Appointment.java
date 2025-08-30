package com.codingshuttle.youtube.hospitalManagement2.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private LocalDateTime appointmentTime ;

    @Column(length = 500)
    private String reason ;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "patient_id" , nullable = false)
    private Patient patient ;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Doctor doctor ;

}