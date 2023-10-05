package com.Pearl.assignment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pearl.assignment.Repository.DoctorRepository;
import com.Pearl.assignment.model.Appointment;
import com.Pearl.assignment.model.Doctor;

@Service
public class DoctorService {
	
	 @Autowired
	    private DoctorRepository doctorRepository;

	   
	    public List<Doctor> getAllDoctors() {
	        return doctorRepository.findAll();
	    }

	  
	    public Optional<Doctor> getDoctorById(Long id) {
	        return doctorRepository.findById(id);
	    }

	    
	    public Appointment bookAppointment(Long doctorId, Appointment appointment) {
	        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);

	        if (optionalDoctor.isPresent()) {
	            Doctor doctor = optionalDoctor.get();
	            
	            
	            return appointment; 
	        } else {
	            throw new DoctorNotFoundException("Doctor with ID " + doctorId + " not found.");
	        }
	    }

}
