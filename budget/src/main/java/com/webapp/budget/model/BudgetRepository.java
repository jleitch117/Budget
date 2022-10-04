package com.webapp.budget.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BudgetRepository extends JpaRepository<Budget, Long> {

}