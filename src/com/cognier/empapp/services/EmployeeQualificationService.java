package com.cognier.empapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cognier.empapp.apis.EmployeeManagmentAPI;
import com.cognier.empapp.database.EmployeeQualificationDataSource;
import com.cognier.empapp.models.Employee;
import com.cognier.empapp.models.Qualification;

/**
 * This is an entry class to find employees who has qualified qualifications
 * 
 * @author Sailakshmi
 *
 */
public class EmployeeQualificationService {

	public static void main(String[] args) {
		// Input-1: Get Required Qualifications
		List<Qualification> reqQualList = EmployeeQualificationDataSource.getRequiredQualifications();
		// Input-2: Get most recent qualifications of employees
		List<Employee> empListWithRecentQual = EmployeeQualificationDataSource.getRecentQualifications();

		// Input-3: Get most existing qualifications of employees through API from Team
		// Management Applications
		List<Employee> empListWithExistingQual = EmployeeManagmentAPI.getEmployeesWithExistingQualifications();

		// Update Qualified EMployees
		updateQualifiedEmplList(reqQualList, empListWithRecentQual, empListWithExistingQual);

		// Print Employee List With Qualifications
		empListWithExistingQual.forEach(emp -> {
			String qualList = emp.getQualificationsList().stream().map(empRecent -> empRecent.getName())
					.collect(Collectors.joining(","));
			System.out.println(emp.getEmpId() + "," + qualList);

		});
	}

	/**
	 * Updates Qualified Employees
	 * 
	 * @param reqQualList
	 * @param empListWithRecentQual
	 * @param empListWithExistingQual
	 */
	private static void updateQualifiedEmplList(List<Qualification> reqQualList, List<Employee> empListWithRecentQual,
			List<Employee> empListWithExistingQual) {

		for (Employee emp : empListWithExistingQual) {
			Employee employee = empListWithRecentQual.stream()
					.filter(empRecent -> empRecent.getEmpId().equals(emp.getEmpId())).findFirst()
					.orElseThrow(() -> new RuntimeException("Employee not exists in recent database"));
			List<Qualification> eligibleQualList = new ArrayList<>();
			// Find Eligible Qualifications
			for (Qualification recentQual : employee.getQualificationsList()) {
				boolean isEligible = reqQualList.stream()
						.anyMatch(qual -> qual.getName().equals(recentQual.getName()) && !recentQual.isExpired());
				if (isEligible) {
					eligibleQualList.add(recentQual);
				}
			}
			emp.setQualificationsList(eligibleQualList);
		}
	}

}
