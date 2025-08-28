package com.codingshuttle.youtube.hospitalManagement2;

import com.codingshuttle.youtube.hospitalManagement2.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
