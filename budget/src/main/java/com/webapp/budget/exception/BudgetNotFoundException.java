package com.webapp.budget.exception;

public class BudgetNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BudgetNotFoundException(Long id){
		super("could not find budget" + id);
	}
}
