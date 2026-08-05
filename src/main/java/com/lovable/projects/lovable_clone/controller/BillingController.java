package com.lovable.projects.lovable_clone.controller;

import com.lovable.projects.lovable_clone.dto.subscription.*;
import com.lovable.projects.lovable_clone.service.PaymentProcessor;
import com.lovable.projects.lovable_clone.service.PlanService;
import com.lovable.projects.lovable_clone.service.SubscriptionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/api")
public class BillingController {

    PlanService planService;
    SubscriptionService subscriptionService;
    PaymentProcessor paymentProcessor;

    @GetMapping("/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription() {
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription());
    }

    @PostMapping("/payments/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(
            @RequestBody CheckoutRequest request
    ) {
        return ResponseEntity.ok(paymentProcessor.createCheckoutSessionUrl(request));
    }

    @PostMapping("/payments/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal() {
        return ResponseEntity.ok(paymentProcessor.openCustomerPortal());
    }

}
