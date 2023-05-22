package com.App.service;

import java.util.List;

import com.App.bindings.request.SearchRequest;
import com.App.bindings.response.PlanResponse;

public interface InsurancePlanService {
	public List<PlanResponse> searchPlans(SearchRequest request);
	
	public List<String> getUniquePlanNames();
	
	public List<String> getUniquePlanStatus();
}
