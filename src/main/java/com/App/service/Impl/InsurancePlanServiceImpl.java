package com.App.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.App.Entity.InsurancePlanEntity;
import com.App.InsurancePlanRepository.InsuranceRepository;
import com.App.bindings.request.SearchRequest;
import com.App.bindings.response.PlanResponse;
import com.App.service.InsurancePlanService;

@Service
public class InsurancePlanServiceImpl  implements InsurancePlanService{
	
	@Autowired
	private InsuranceRepository insuranceRepo;
	
	@Override
	public List<PlanResponse> searchPlans(SearchRequest request) {
		InsurancePlanEntity entity = new InsurancePlanEntity();
		if(request !=null && request.getPlanName() !=null && !request.getPlanName().equals(""))
		{
			entity.setPlanName(request.getPlanName());
		}
		
		if(request !=null && request.getPlanStatus() !=null && !request.getPlanStatus().equals(""))
		{
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		Example<InsurancePlanEntity> of = Example.of(entity);
		List<InsurancePlanEntity> findAll = insuranceRepo.findAll(of);
		
		List<PlanResponse> responses = new ArrayList<>();
		for(InsurancePlanEntity plan : findAll)
		{
			PlanResponse planResponse = new PlanResponse();
			BeanUtils.copyProperties(plan, planResponse);
			responses.add(planResponse);
		}
		return responses;
	}

	@Override
	public List<String> getUniquePlanNames() {
		return insuranceRepo.getPlanNames();
	}

	@Override
	public List<String> getUniquePlanStatus() {
		return insuranceRepo.getPlanStatus();
	}

}
