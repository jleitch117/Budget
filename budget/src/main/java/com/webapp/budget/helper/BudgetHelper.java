package com.webapp.budget.helper;

import com.webapp.budget.model.Budget;
import com.webapp.budget.model.BudgetRepository;

public class BudgetHelper {

	public static Budget putMapping(BudgetRepository repo, Budget newBudget, Long id) {
		
		return repo.findById(id)
		.map(budget -> { 
			budget.setIncome(newBudget.getIncome());
			budget.setExpenses(newBudget.getExpenses());
			return repo.save(budget);
		})
		.orElseGet(() -> {
			newBudget.setId(id);
			return repo.save(newBudget);
		});
	}

}
