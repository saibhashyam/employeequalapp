package com.cognier.empapp.models;

import java.util.List;

public class Employee {

	private String name;
	private String empId;
	private List<Qualification> qualificationsList;

	public Employee(String name, String empId, List<Qualification> existingQualifications) {
		this.name = name;
		this.empId = empId;
		this.qualificationsList = existingQualifications;
	}

	public String getName() {
		return name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public List<Qualification> getQualificationsList() {
		return qualificationsList;
	}

	public void setQualificationsList(List<Qualification> qualificationsList) {
		this.qualificationsList = qualificationsList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
