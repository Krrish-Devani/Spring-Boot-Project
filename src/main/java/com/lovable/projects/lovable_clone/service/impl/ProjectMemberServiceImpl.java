package com.lovable.projects.lovable_clone.service.impl;

import com.lovable.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.lovable.projects.lovable_clone.dto.member.MemberResponse;
import com.lovable.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.lovable.projects.lovable_clone.mapper.ProjectMemberMapper;
import com.lovable.projects.lovable_clone.repository.ProjectMemberRepository;
import com.lovable.projects.lovable_clone.repository.ProjectRepository;
import com.lovable.projects.lovable_clone.repository.UserRepository;
import com.lovable.projects.lovable_clone.security.AuthUtil;
import com.lovable.projects.lovable_clone.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;
    AuthUtil authUtil;

    @Override
    @PreAuthorize("@security.canViewMembers(#projectId)")
    public List<MemberResponse> getProjectMembers(Long projectId) {
        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request) {
        return null;
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId) {

    }
}
