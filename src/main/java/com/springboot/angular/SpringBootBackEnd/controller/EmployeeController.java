package com.springboot.angular.SpringBootBackEnd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.angular.SpringBootBackEnd.model.Employee;
import com.springboot.angular.SpringBootBackEnd.repository.EmployeeRepository;

//@CrossOrigin(origins ="*")
@RestController
@RequestMapping ("api/v1")
@CrossOrigin(origins ="*")
public class EmployeeController {
	@Autowired
	EmployeeRepository empRepo;
	
//	@CrossOrigin(origins = "http://localhost:8080")
	//@CrossOrigin(origins ="*")
	@GetMapping ("/employees")
	public List<Employee> getAllEmployee(){
		System.out.println(".........................");
		return empRepo.findAll();
	
	} 
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee emp ) {		
		return empRepo.save(emp);
		
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") long empiId) {
		Employee emp=empRepo.findById(empiId).orElseThrow (()-> new ResourceNotFoundException("Employee Not find " + empiId ));
		 return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long empiId, @RequestBody Employee employee  ) {
		Employee emp=empRepo.findById(empiId).orElseThrow (()-> new ResourceNotFoundException("Employee Not find " + empiId ));
		
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmailId(employee.getEmailId());
		Employee updatedEmploye=empRepo.save(emp);
		 return ResponseEntity.ok(updatedEmploye);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable("id") long id){
		Employee emp=empRepo.findById(id).orElseThrow (()-> new ResourceNotFoundException("Employee Not find " + id ));
		empRepo.delete(emp);
		
		Map<String,Boolean> response = new HashMap<String,Boolean>();
		response.put("delete", true);
		return ResponseEntity.ok(response);
		
		
	}
	

}
