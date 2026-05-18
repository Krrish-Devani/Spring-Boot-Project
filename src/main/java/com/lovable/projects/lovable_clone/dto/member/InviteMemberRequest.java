package com.lovable.projects.lovable_clone.dto.member;

import com.lovable.projects.lovable_clone.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
