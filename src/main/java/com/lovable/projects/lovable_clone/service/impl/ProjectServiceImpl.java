package com.lovable.projects.lovable_clone.service.impl;

import com.lovable.projects.lovable_clone.dto.project.ProjectRequest;
import com.lovable.projects.lovable_clone.dto.project.ProjectResponse;
import com.lovable.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import com.lovable.projects.lovable_clone.entity.Project;
import com.lovable.projects.lovable_clone.entity.User;
import com.lovable.projects.lovable_clone.mapper.ProjectMapper;
import com.lovable.projects.lovable_clone.repository.ProjectMemberRepository;
import com.lovable.projects.lovable_clone.repository.ProjectRepository;
import com.lovable.projects.lovable_clone.repository.UserRepository;
import com.lovable.projects.lovable_clone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    ProjectMemberRepository projectMemberRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner = userRepository.findById(userId).orElseThrow();

        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();

        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        var projectsWithRoles = projectRepository.findAllAccessibleByUser(userId);
        return projectsWithRoles.stream()
                .map(p -> projectMapper.toProjectSummaryResponse());
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
