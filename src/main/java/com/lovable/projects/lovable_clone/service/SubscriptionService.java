package com.lovable.projects.lovable_clone.service;

import com.lovable.projects.lovable_clone.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {

    SubscriptionResponse getCurrentSubscription();

    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);
}
