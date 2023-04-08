package com.example.lhs.handleRequests.service.impl;

import java.util.concurrent.*;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.lhs.handleRequests.domain.Employee;
import com.example.lhs.handleRequests.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee getFirst(){

		Employee employee = new Employee();
		employee.setName("Felipe");
		employee.setEnrollment("123456");
		employee.setLastName("Souza");
		employee.setAge(30);

		return employee;
	}

	@Override
	@Async
	public CompletableFuture<Employee> getByEnrollment(String enrollment) {

		Employee employee = new Employee();
		employee.setName("Felipe");
		employee.setEnrollment(enrollment);
		employee.setLastName("Souza");
		employee.setAge(30);

		return CompletableFuture.completedFuture(employee);
	}

	@Override
	public Employee updateNameByEnrollment(String enrollment, String name) throws ExecutionException, InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		return executor.submit(() -> {
			Employee employeeResult = new Employee();
			employeeResult.setName(name);
			employeeResult.setEnrollment(enrollment);
			employeeResult.setLastName("Souza");
			employeeResult.setAge(30);
			return employeeResult;
		}).get();
	}
}
