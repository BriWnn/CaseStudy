package com.medms.mms.Service;

import java.util.List;

import com.medms.mms.Entity.Staff;

public interface StaffService  {
	
	
	List<Staff> getAllStaff();
	
	Staff saveStaff(Staff staff);
	
	Staff getStaffById(Long id);
	
	Staff updateStaff(Staff staff);
	
	void deleteStaffById(Long id);

}
