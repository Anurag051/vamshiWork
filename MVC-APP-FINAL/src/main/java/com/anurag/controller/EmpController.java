package com.anurag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.model.Employee;
import com.anurag.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService empService;

	/*---Add new EMP---*/
	@PostMapping("/emp")
	public ResponseEntity<?> save(@RequestBody Employee emp) {
		long id = empService.save(emp);
		return ResponseEntity.ok().body("New Employee has been Added with ID:" + id);
	}

	/*---Get a EMP by id---*/
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> get(@PathVariable("id") long id) {
		Employee emp = empService.get(id);
		return ResponseEntity.ok().body(emp);
	}

	/*---get all EMP---*/
	@GetMapping("/emp")
	public ResponseEntity<List<Employee>> list() {
		List<Employee> emp = empService.list();
		return ResponseEntity.ok().body(emp);
	}

	/*---Update a EMP by id---*/
	@PutMapping("/emp/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Employee emp) {
		empService.update(id, emp);
		return ResponseEntity.ok().body("EMP has been updated successfully.");
	}

	/*---Delete a EMP by id---*/
	@DeleteMapping("/emp/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		empService.delete(id);
		return ResponseEntity.ok().body("EMP has been deleted successfully.");
	}
}