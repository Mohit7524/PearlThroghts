package com.Pearl.assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pearl.assignment.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
