package com.lovable.projects.lovable_clone.service;

import com.lovable.projects.lovable_clone.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {

    List<PlanResponse> getAllActivePlans();

}
