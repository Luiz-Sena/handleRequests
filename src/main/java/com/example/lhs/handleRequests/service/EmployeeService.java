package com.example.lhs.handleRequests.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.example.lhs.handleRequests.domain.Employee;

public interface EmployeeService {

	Employee getFirst();
	CompletableFuture<Employee> getByEnrollment(String enrollment);
	Employee updateNameByEnrollment(String enrollment, String name) throws ExecutionException, InterruptedException;
}
