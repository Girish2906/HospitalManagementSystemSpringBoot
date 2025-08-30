package com.codingshuttle.youtube.hospitalManagement2.service;


import com.codingshuttle.youtube.hospitalManagement2.entity.Appointment;
import com.codingshuttle.youtube.hospitalManagement2.entity.Doctor;
import com.codingshuttle.youtube.hospitalManagement2.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement2.repository.AppointmentRepository;
import com.codingshuttle.youtube.hospitalManagement2.repository.DoctorRepository;
import com.codingshuttle.youtube.hospitalManagement2.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository ;
    private final DoctorRepository doctorRepository ;
    private final PatientRepository patientRepository ;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment , Long doctorId , Long patientId ){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow() ;
        Patient patient = patientRepository.findById(patientId).orElseThrow() ;
        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment cannot be created") ;
        appointment.setDoctor(doctor) ;
        appointment.setPatient(patient) ;
        patient.getAppointments().add(appointment) ;
        appointmentRepository.save(appointment) ;
        return appointment ;
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId , Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow() ;
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow() ;
        appointment.setDoctor(doctor) ; // will automatically call the update, because it is dirty
        doctor.getAppointments().add(appointment) ; // for bidirectional consistency
        return appointment ;
    }
}
