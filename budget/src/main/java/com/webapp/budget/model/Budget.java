package com.webapp.budget.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Budget {

	private @Id @GeneratedValue Long id;
	private String name;
	private double income;
	private double expenses;
	
	public Budget() {}
	
	public Budget( String name, double income, double expenses){
		this.setExpenses(expenses);
		this.setIncome(income);
		this.setName(name);
	}
	public Double getIncome() {
		return this.income;
	}

	public Double getExpenses() {
		return this.expenses;
	}

	public void setIncome(double income) {
		this.income = income;
		
	}

	public void setExpenses(double expenses) {
		this.expenses = expenses;
		
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return this.id;
	}

}
