package com.medms.mms.Service;

import java.util.List;

import com.medms.mms.Entity.Patient;


public interface PatientService {
	
	
List<Patient> getAllPatients();
	
Patient savePatient(Patient patient);
	
Patient getPatientById(Long id);
	
Patient updatePatient(Patient patient);
	
void deletePatientById(Long id);
	

}
