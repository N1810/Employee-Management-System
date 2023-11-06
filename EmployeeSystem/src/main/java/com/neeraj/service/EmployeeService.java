package com.neeraj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.Dao.EmployeeDao;
import com.neeraj.employee.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao empdao;

	public void addEmp(Employee e) {
		empdao.save(e);
	}

	public List<Employee> getAllEmployee() {

		return empdao.findAll();
	}

	public Employee getEmpById(Long id) {

		Optional<Employee> e = empdao.findById(id);
		if (e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}

	public void deleteEmp(Long id) {

		empdao.deleteById(id);
	}

}
