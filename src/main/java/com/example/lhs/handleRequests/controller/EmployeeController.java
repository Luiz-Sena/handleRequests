package com.example.lhs.handleRequests.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.lhs.handleRequests.domain.Employee;
import com.example.lhs.handleRequests.restApi.EmployeeApi;
import com.example.lhs.handleRequests.service.EmployeeService;

@RestController
public class EmployeeController implements EmployeeApi {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public Employee getFirst(){
		return employeeService.getFirst();
	}

	@Override
	public CompletableFuture<Employee> getByEnrollment(String enrollment){
		return employeeService.getByEnrollment(enrollment);
	}

	@Override
	public Employee updateNameByEnrollment(String enrollment, String name) throws ExecutionException, InterruptedException {
		return employeeService.updateNameByEnrollment(enrollment, name);
	}
}
