package com.webapp.budget.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.budget.exception.BudgetNotFoundException;
import com.webapp.budget.helper.BudgetHelper;
import com.webapp.budget.model.Budget;
import com.webapp.budget.model.BudgetRepository;

@RestController
public class BudgetController {
	
	
	private final BudgetRepository repo;
	
	BudgetController(BudgetRepository repo) {
		this.repo = repo;
	}
	
	
	@GetMapping("/budget")
	List<Budget> all() { 
		return repo.findAll();
	}
	
	@PostMapping("/budget")
	Budget newBudget(@RequestBody Budget newBudget) { 
		return repo.save(newBudget);
	}
	
	@GetMapping("/budget/{id}")
	Budget one(@PathVariable Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new BudgetNotFoundException(id));
	}
	
	@PutMapping("/budget/{id}")
	Budget replaceBudget(@RequestBody Budget newBudget, @PathVariable Long id) {
		return BudgetHelper.putMapping(repo, newBudget, id);
	}
	
	@DeleteMapping("/budget/{id}")
	void deleteBudget(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
