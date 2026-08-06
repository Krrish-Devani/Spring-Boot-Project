package com.lovable.projects.lovable_clone.service;

import com.lovable.projects.lovable_clone.dto.subscription.CheckoutRequest;
import com.lovable.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.lovable.projects.lovable_clone.dto.subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;

public interface PaymentProcessor {

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
