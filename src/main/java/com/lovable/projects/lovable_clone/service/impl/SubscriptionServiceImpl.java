package com.lovable.projects.lovable_clone.service.impl;

import com.lovable.projects.lovable_clone.dto.subscription.CheckoutRequest;
import com.lovable.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.lovable.projects.lovable_clone.dto.subscription.PortalResponse;
import com.lovable.projects.lovable_clone.dto.subscription.SubscriptionResponse;
import com.lovable.projects.lovable_clone.entity.Subscription;
import com.lovable.projects.lovable_clone.enums.SubscriptionStatus;
import com.lovable.projects.lovable_clone.mapper.SubscriptionMapper;
import com.lovable.projects.lovable_clone.repository.PlanRepository;
import com.lovable.projects.lovable_clone.repository.ProjectMemberRepository;
import com.lovable.projects.lovable_clone.repository.SubscriptionRepository;
import com.lovable.projects.lovable_clone.repository.UserRepository;
import com.lovable.projects.lovable_clone.security.AuthUtil;
import com.lovable.projects.lovable_clone.service.SubscriptionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SubscriptionServiceImpl implements SubscriptionService {

    AuthUtil authUtil;
    SubscriptionRepository subscriptionRepository;
    SubscriptionMapper subscriptionMapper;
    UserRepository userRepository;
    PlanRepository planRepository;
    ProjectMemberRepository projectMemberRepository;

    // private final Integer FREE_TIER_PROJECTS_ALLOWED = 100;

    @Override
    public SubscriptionResponse getCurrentSubscription() {
        Long userId = authUtil.getCurrentUserId();

        var currentSubscription = subscriptionRepository.findByUserIdAndStatusIn(userId, Set.of(
                SubscriptionStatus.ACTIVE, SubscriptionStatus.PAST_DUE,
                SubscriptionStatus.TRIALING
        )).orElse(
                new Subscription()
        );

        return subscriptionMapper.toSubscriptionResponse(currentSubscription);
    }

    @Override
    public void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId) {

    }

    @Override
    public void updateSubscription(String id, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId) {

    }

    @Override
    public void cancelSubscription(String id) {

    }

    @Override
    public void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd) {

    }

    @Override
    public void markSubscriptionPastDue(String subId) {

    }
}
