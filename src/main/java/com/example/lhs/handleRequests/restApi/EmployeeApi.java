package com.example.lhs.handleRequests.restApi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lhs.handleRequests.domain.Employee;

@RequestMapping("/employee")
public interface EmployeeApi {

	//Synchronous handling
	@GetMapping
	Employee getFirst();

	//Asynchronous handling
	@GetMapping("/enrollment/{enrollment}")
	CompletableFuture<Employee> getByEnrollment(@PathVariable String enrollment);

	//Concurrent
	@PutMapping("/enrollment/{enrollment}")
	Employee updateNameByEnrollment(@PathVariable String enrollment, @RequestParam String name) throws ExecutionException, InterruptedException;

}
