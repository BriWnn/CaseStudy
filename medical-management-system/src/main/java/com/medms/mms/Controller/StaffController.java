package com.medms.mms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medms.mms.Entity.Staff;
import com.medms.mms.Service.StaffService;

@Controller
public class StaffController {

	private StaffService staffService;

	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
	
	//Handler method to handle list Staff and return mode and view
	@GetMapping("/staff")
	public String listStaff(Model model) {
		model.addAttribute("staff", staffService.getAllStaff());
		return "staff";		
	}
	
	
	@GetMapping("/staff/new")
	public String createStaffForm(Model model) {
		
		//Create staff object to hold staff member form data
		Staff staff = new Staff();
		
		model.addAttribute("Staff", staff);
		return "create_staff";
	}
	
	@PostMapping("/staff")
	public String saveStaff(@ModelAttribute("staff") Staff staff) {
		staffService.saveStaff(staff);
		return "redirect:/staff";
	}
	
	@GetMapping("/staff/edit/{id}")
	public String editStaffForm(@PathVariable Long id, Model model) {
		model.addAttribute("staff", staffService.getStaffById(id));
		return "edit_staff";
	}

	@PostMapping("/staff/{id}")
	public String updateStaff(@PathVariable Long id,
			@ModelAttribute("staff") Staff staff,
			Model model) {
		
		// get staff from database by id
		Staff existingStaff = staffService.getStaffById(id);
		existingStaff.setId(id);
		existingStaff.setFirstName(staff.getFirstName());
		existingStaff.setLastName(staff.getLastName());
		existingStaff.setTitle(staff.getTitle());
		
		// save updated staff object
		staffService.updateStaff(existingStaff);
		return "redirect:/staff";		
	}
	
	// handler method to handle delete staff request
	
	@GetMapping("/staff/{id}")
	public String deleteStaff(@PathVariable Long id) {
		staffService.deleteStaffById(id);
		return "redirect:/staff";
	}
	
	
}
