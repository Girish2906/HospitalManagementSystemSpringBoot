package com.codingshuttle.youtube.hospitalManagement2.repository;

import com.codingshuttle.youtube.hospitalManagement2.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}