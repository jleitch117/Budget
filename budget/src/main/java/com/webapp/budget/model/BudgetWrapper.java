package com.webapp.budget.model;

import java.util.ArrayList;
import java.util.List;

public class BudgetWrapper {
	
    private List<Budget> budgets = new ArrayList<Budget>();

    // default and parameterized constructor

    public void addBudget(Budget budget) {
        this.budgets.add(budget);
    }
	
    public List<Budget> getBudgets(){
    	return budgets;
    }
    
    public List<Budget> setBudgets(List<Budget> newBudgets) {
    	this.budgets = newBudgets;
		return this.budgets;
    	
    }
}