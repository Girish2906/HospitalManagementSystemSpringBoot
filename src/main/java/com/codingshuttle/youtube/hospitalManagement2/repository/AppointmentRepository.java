package com.codingshuttle.youtube.hospitalManagement2.repository;

import com.codingshuttle.youtube.hospitalManagement2.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}