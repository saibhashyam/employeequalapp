package com.cognier.empapp.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cognier.empapp.models.Employee;
import com.cognier.empapp.models.Qualification;
/**
 * 
 * @author Sailakshmi
 *
 */
public class EmployeeQualificationDataSource {
	/**
	 * The database connected from Team App
	 */
	static List<Employee> empDatabase = new ArrayList<>();

	static {
		empDatabase.add(new Employee("Emp1", "Emp1",
				Arrays.asList(new Qualification("Java", false), new Qualification("C#", false),
						new Qualification("NodeJS", false), new Qualification("Angular", false))));

		empDatabase.add(new Employee("Emp2", "Emp2",
				Arrays.asList(new Qualification("Java", false), new Qualification("NodeJS", false))));

		empDatabase.add(new Employee("Emp3", "Emp3",
				Arrays.asList(new Qualification("Java", false), new Qualification("AWS", false))));

		empDatabase.add(new Employee("Emp4", "Emp4",
				Arrays.asList(new Qualification("Java", false), new Qualification("C#", false),
						new Qualification("NodeJS", false), new Qualification("Angular", false))));
	}

	/**
	 * Return company required qualifications
	 * 
	 * @return List of qualifications
	 */

	public static List<Qualification> getRequiredQualifications() {
		return Arrays.asList(new Qualification("Java", false), new Qualification("C#", false),
				new Qualification("NodeJS", false), new Qualification("Angular", false));
	}

	/**
	 * Get all employees with recent qualifications from source database
	 * 
	 * @return list of employees
	 */

	public static List<Employee> getRecentQualifications() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Emp1", "Emp1",
				Arrays.asList(new Qualification("Java", false), new Qualification("C#", false),
						new Qualification("NodeJS", true), new Qualification("Angular", false))));

		empList.add(new Employee("Emp2", "Emp2",
				Arrays.asList(new Qualification("Java", false), new Qualification("C#", false),
						new Qualification("NodeJS", false), new Qualification("Angular", false),
						new Qualification("AWS", false))));

		empList.add(new Employee("Emp3", "Emp3", Arrays.asList(new Qualification("Java", false),
				new Qualification("NodeJS", false), new Qualification("AWS", false))));

		empList.add(new Employee("Emp4", "Emp4",
				Arrays.asList(new Qualification("Java", false), new Qualification("C#", false),
						new Qualification("Angular", false), new Qualification("NodeJS", false),
						new Qualification("AWS", false))));

		return empList;
	}

	/**
	 * Find employee qualifications from Team app data source
	 * 
	 * @param empId
	 * @return
	 */

	public static Employee findByEmployee(String empId) {
		return empDatabase.stream().filter(emp -> emp.getEmpId().equals(empId)).findFirst()
				.orElseThrow(() -> new RuntimeException("Employee does not exists " + empId));
	}

	/**
	 * Return the employees with existing qualifications
	 * 
	 * @return List of employees
	 */

	public static List<Employee> getEmployeesWithExistingQualifications() {
		return empDatabase;
	}

}
