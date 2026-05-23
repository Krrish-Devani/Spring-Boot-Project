package com.lovable.projects.lovable_clone.service.impl;

import com.lovable.projects.lovable_clone.dto.auth.AuthResponse;
import com.lovable.projects.lovable_clone.dto.auth.LoginRequest;
import com.lovable.projects.lovable_clone.dto.auth.SignupRequest;
import com.lovable.projects.lovable_clone.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
