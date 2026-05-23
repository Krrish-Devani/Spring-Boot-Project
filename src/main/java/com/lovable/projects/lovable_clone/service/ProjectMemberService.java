package com.lovable.projects.lovable_clone.service;

import com.lovable.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.lovable.projects.lovable_clone.dto.member.MemberResponse;
import com.lovable.projects.lovable_clone.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {

    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, InviteMemberRequest request, Long userId);

    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);

}
