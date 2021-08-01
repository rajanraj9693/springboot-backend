package com.springboot.angular.SpringBootBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.angular.SpringBootBackEnd.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Long>{
 
}
