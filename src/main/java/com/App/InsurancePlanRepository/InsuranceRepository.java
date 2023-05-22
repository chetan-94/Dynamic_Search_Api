package com.App.InsurancePlanRepository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.App.Entity.InsurancePlanEntity;

public interface InsuranceRepository extends JpaRepository<InsurancePlanEntity, Serializable> {
	@Query("select distinct PlanName  from InsurancePlanEntity")
	public List<String> getPlanNames();
	
	@Query("select distinct PlanStatus  from InsurancePlanEntity")
	public List<String> getPlanStatus();
}
