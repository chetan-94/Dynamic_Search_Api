package com.App.bindings.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanResponse {
	private Integer PlanId;
	private String PlanName;
	private String PlanHolderName;
	private Long PlanHolderSSN;
	private String PlanStatus;
}
