package com.lovable.projects.lovable_clone.service.impl;

import com.lovable.projects.lovable_clone.dto.subscription.CheckoutRequest;
import com.lovable.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.lovable.projects.lovable_clone.dto.subscription.PortalResponse;
import com.lovable.projects.lovable_clone.service.PaymentProcessor;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StripePaymentProcessor implements PaymentProcessor {
    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal() {
        return null;
    }
}
