package com.codingshuttle.youtube.hospitalManagement2.repository;

import com.codingshuttle.youtube.hospitalManagement2.dto.BloodGroupCountResponseEntity;
import com.codingshuttle.youtube.hospitalManagement2.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement2.entity.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate of, String s);

    List<Patient> findByNameContainingIgnoreCase(String query) ;
    // these all @Query things is JPQL: jakarta persistence query language
    @Query("SELECT p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup( @Param("bloodGroup") BloodGroupType bloodGroup);


    @Query("SELECT p.bloodGroup , count(p) from Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroupType() ;

    @Query(value = "select * from patient_tlb" , nativeQuery = true)
    List<Patient> findAllPatients() ;


    @Query("SELECT p from Patient p left join fetch p.appointments a left join fetch a.doctor")
    List<Patient> findAllPatientWithAppointment() ;


//    @Query("select new com.codingshuttle.youtube.hospitalManagement2.dto.")
//    List<BloodGroupCountResponseEntity> countEachBloodGroupType() ;

}