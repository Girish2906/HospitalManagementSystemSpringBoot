package com.codingshuttle.youtube.hospitalManagement2.service;

import com.codingshuttle.youtube.hospitalManagement2.entity.Insurance;
import com.codingshuttle.youtube.hospitalManagement2.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement2.repository.InsuranceRepository;
import com.codingshuttle.youtube.hospitalManagement2.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository ;
    private final PatientRepository patientRepository ;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance , Long patientId ){
        Patient patient = patientRepository.findById(patientId).
                orElseThrow(() ->  new EntityNotFoundException("Patient Not Found With Id: " + patientId)) ;

        patient.setInsurance(insurance) ;
        insurance.setPatient(patient) ; // to maintain bidirectional consistency
        return patient ;
    }

    @Transactional
    public Patient dissociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(() ->
                new IllegalArgumentException("Patient not foud with id : " + patientId)) ;
        patient.setInsurance(null);
        return patient ;
    }

}
