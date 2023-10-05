package com.Pearl.assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pearl.assignment.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>  {

}
