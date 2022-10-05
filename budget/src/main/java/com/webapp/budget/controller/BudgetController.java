package com.webapp.budget.controller;

import java.util.List;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.webapp.budget.exception.BudgetNotFoundException;
import com.webapp.budget.helper.BudgetHelper;
import com.webapp.budget.model.Budget;
import com.webapp.budget.model.BudgetRepository;
import com.webapp.budget.model.BudgetWrapper;

@Controller
public class BudgetController {
	
	
	private final BudgetRepository repo;
	
	BudgetController(BudgetRepository repo) {
		this.repo = repo;
	}
	
	
	@GetMapping("/budgets")
	String all(Model model) { 
		List<Budget> budgets = (List<Budget>) repo.findAll();
		model.addAttribute("budgets", budgets);
		return "budgets";
	}
	
	@GetMapping("/budget")
	String createBudget(Model model) {
		BudgetWrapper budgetForm = new BudgetWrapper();
		budgetForm.addBudget(new Budget());
		model.addAttribute("form", budgetForm);
		return "budget";
	}
	
	@PostMapping("/save")
	public String saveBooks(@ModelAttribute BudgetWrapper form, Model model) {
	    repo.saveAll(form.getBudgets());

	    model.addAttribute("budgets", repo.findAll());
	    return "redirect:/budgets";
	}
	
	@PostMapping("/budget")
	String newBudget(@RequestBody Budget newBudget, Model model) { 
		Budget budget = repo.save(newBudget);
		model.addAttribute("budget", budget);
		return "budgets";
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
