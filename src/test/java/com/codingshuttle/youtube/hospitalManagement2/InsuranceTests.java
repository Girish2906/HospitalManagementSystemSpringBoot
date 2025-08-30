package com.codingshuttle.youtube.hospitalManagement2;

import com.codingshuttle.youtube.hospitalManagement2.entity.Appointment;
import com.codingshuttle.youtube.hospitalManagement2.entity.Insurance;
import com.codingshuttle.youtube.hospitalManagement2.entity.Patient;
import com.codingshuttle.youtube.hospitalManagement2.service.AppointmentService;
import com.codingshuttle.youtube.hospitalManagement2.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {


    @Autowired
    private InsuranceService insuranceService ;

    @Autowired
    private AppointmentService appointmentService ;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_123")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030 , 12 , 12))
                .build() ;
        Patient patient = insuranceService.assignInsuranceToPatient(insurance , 1L) ;
//        System.out.println(patient);
        var newPatient = insuranceService.dissociateInsuranceFromPatient(patient.getId()) ;
        System.out.println(newPatient);

    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025 , 11 , 1 , 15 , 30 , 30))
                .reason("Cancer")
                .build() ;
        var newAppointment = appointmentService.createNewAppointment(appointment , 1L , 2L) ;
        System.out.println(newAppointment);

        var updatedAppointment =  appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId() , 3L) ;
        System.out.println(updatedAppointment);
    }



    @Test
    public void testLombokMethods() {
        Insurance insurance = new Insurance();
        insurance.setProvider("Test Provider"); // This should work

        System.out.println(insurance.getProvider()); // This should work

        // Test the builder
        Insurance built = Insurance.builder()
                .provider("Built Provider")
                .build();

        System.out.println(built.getProvider()); // This should work
    }

}