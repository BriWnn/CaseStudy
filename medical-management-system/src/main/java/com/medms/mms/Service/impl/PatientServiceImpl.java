package com.medms.mms.Service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medms.mms.Entity.Patient;

import com.medms.mms.Repository.PatientRepository;

import com.medms.mms.Service.PatientService;



@Service
public class PatientServiceImpl implements PatientService {
	
	
private PatientRepository patientRepository;
	
	
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}



	@Override
	public List<Patient> getAllPatients() {
		System.out.println("Getting data from DB for Testing:" + patientRepository);
		return patientRepository.findAll();
	}
	
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	@Override
	public Patient getPatientById(Long id) {
		return patientRepository.findById(id).get();
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);	
	}

	
	

}
