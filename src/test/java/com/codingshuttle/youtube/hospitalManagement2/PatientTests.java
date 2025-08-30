package com.codingshuttle.youtube.hospitalManagement2;

import com.codingshuttle.youtube.hospitalManagement2.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement2.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository ;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment() ;
        System.out.println(patientList);
    }

    @Transactional
    @Test
    public void testTransactionMethods(){
//        Patient patient = patientRepository.findByName("diya sharma") ;
//        System.out.println(patient);
//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(2002 , 10 , 10)
//                , "diyaSharma@gmail.com") ;
//        List<Patient> patientList = patientRepository.findByNameContainingIgnoreCase("Di") ;
//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE) ;
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType() ;
//        for(Object[] objects: bloodGroupList){
//            System.out.println(objects[0] + " " + objects[1]);
//        }
        List<Patient> patientList = patientRepository.findAllPatients() ;
        for(Patient patient: patientList )

            System.out.println(patient);

    }

}
