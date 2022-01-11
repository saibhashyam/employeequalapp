package com.cognier.empapp.apis;

import java.util.List;

import javax.annotation.PostConstruct;

import com.cognier.empapp.database.EmployeeQualificationDataSource;
import com.cognier.empapp.models.Employee;

/**
 * This is an API class to return an employee qualifications
 * 
 * @author Sailakshmi
 *
 */
public class EmployeeManagmentAPI {

	/**
	 * Find employee qualifications from Team app data source
	 * 
	 * @param empId
	 * @return
	 */

	public static Employee findByEmployee(String empId) {
		return EmployeeQualificationDataSource.findByEmployee(empId);
	}

	/**
	 * Return the employees with existing qualifications
	 * 
	 * @return List of employees
	 */

	public static List<Employee> getEmployeesWithExistingQualifications() {
		return EmployeeQualificationDataSource.getEmployeesWithExistingQualifications();
	}

}
