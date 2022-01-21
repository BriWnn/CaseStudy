package com.medms.mms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medms.mms.Entity.Patient;

import com.medms.mms.Service.PatientService;


@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	//Handler method to handle list patient and return view
	@GetMapping("/patient")
	public String listPatient(Model model) {
		model.addAttribute("patient", patientService.getAllPatients());
		return "patient";		
	}
	
	//List patients in staff user view
	@GetMapping("/staffview")
	public String listPatient2(Model model) {
		model.addAttribute("patient", patientService.getAllPatients());
		return "staffview";		
	}
	
	
	
	
	
	
	@GetMapping("/patient/new")
	public String createPatientForm(Model model) {
		
		//Create patient object to hold patient form data
		Patient patient = new Patient();
		
		model.addAttribute("Patient", patient);
		return "create_patient";
	}
	
	@PostMapping("/patient")
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		patientService.savePatient(patient);
		return "redirect:/patient";
	}
	
	@GetMapping("/patient/edit/{id}")
	public String editPatientForm(@PathVariable Long id, Model model) {
		model.addAttribute("patient", patientService.getPatientById(id));
		return "edit_patient";
	}

	@PostMapping("/patient/{id}")
	public String updatePatient(@PathVariable Long id,
			@ModelAttribute("patient") Patient patient,
			Model model) {
		
		// get patient from database by id
		Patient existingPatient = patientService.getPatientById(id);
		existingPatient.setId(id);
		existingPatient.setFirstName(patient.getFirstName());
		existingPatient.setLastName(patient.getLastName());
		existingPatient.setDob(patient.getDob());
		
		// save updated patient object
		patientService.updatePatient(existingPatient);
		return "redirect:/patient";		
	}
	
	// handler method to handle delete patient request
	
	@GetMapping("/patient/{id}")
	public String deletePatient(@PathVariable Long id) {
		patientService.deletePatientById(id);
		return "redirect:/patient";
	}
	
	

}
