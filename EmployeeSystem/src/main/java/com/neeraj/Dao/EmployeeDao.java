package com.neeraj.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neeraj.employee.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
