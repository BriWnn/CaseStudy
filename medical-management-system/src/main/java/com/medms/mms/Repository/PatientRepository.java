package com.medms.mms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medms.mms.Entity.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long>{

}
