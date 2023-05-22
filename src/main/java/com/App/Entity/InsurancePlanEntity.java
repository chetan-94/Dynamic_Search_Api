package com.App.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Insurance_Plans")
public class InsurancePlanEntity {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAN_ID")
	private Integer PlanId;
	
	@Column(name = "PLAN_NAME")
	private String PlanName;
	
	@Column(name = "PLAN_HOLDER_NAME")
	private String PlanHolderName;
	
	@Column(name = "PLAN_HOLDER_SSN")
	private Long PlanHolderSSN;
	
	@Column(name = "PLAN_STATUS")
	private String PlanStatus;
}
