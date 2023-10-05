package com.Pearl.assignment.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Pearl.assignment.Service.DoctorService;
import com.Pearl.assignment.model.Appointment;
import com.Pearl.assignment.model.Doctor;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
    private DoctorService doctorService;

    
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

 
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        if (doctor.isPresent()) {
            return ResponseEntity.ok(doctor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   
    @PostMapping("/{doctorId}/appointments")
    public ResponseEntity<Appointment> bookAppointment(
            @PathVariable Long doctorId,
            @RequestBody Appointment appointment
    ) {
        try {
            Appointment bookedAppointment = doctorService.bookAppointment(doctorId, appointment);
            return ResponseEntity.ok(bookedAppointment);
        } catch (DoctorNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (AppointmentNotAvailableException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
