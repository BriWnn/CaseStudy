package com.medms.mms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.medms.mms.Entity.Patient;
import com.medms.mms.Repository.PatientRepository;
import com.medms.mms.Service.PatientService;




@RunWith(SpringRunner.class)
@SpringBootTest
class MedicalManagementSystemApplicationTests {
	
	@Autowired
	private PatientService service;
	
	
	@MockBean
	private PatientRepository repository;
	
	
	
	@Test
	public void listPatientTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Patient("Bill", "Gates", "04/24/1944")).collect(Collectors.toList()));
		assertEquals(1, service.getAllPatients().size());
		
		
	}
}
