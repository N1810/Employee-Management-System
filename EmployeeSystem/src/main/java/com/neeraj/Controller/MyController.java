package com.neeraj.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neeraj.employee.Employee;
import com.neeraj.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/")
	public String home(Model m) {

		List<Employee> emp = service.getAllEmployee();
		m.addAttribute("emp", emp);

		return "index";
	}

	@GetMapping("/addemp")
	public String Addemp() {
		return "addemp";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		System.out.println(e);

		service.addEmp(e);
		session.setAttribute("msg", "Employee Added Successfully....");
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model m) {

		Employee e = service.getEmpById(id);

		m.addAttribute("emp", e);

		return "edit";

	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {

		service.addEmp(e);
		session.setAttribute("msg", "Emp Data Updated Successfully..");
		return "redirect:/";

	}

	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable Long id, HttpSession session) {

		service.deleteEmp(id);
		session.setAttribute("msg", "Emp Data Deleted Successfully..");

		return "redirect:/";

	}

}
