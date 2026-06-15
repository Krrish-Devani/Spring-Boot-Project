package com.lovable.projects.lovable_clone.mapper;

import com.lovable.projects.lovable_clone.dto.project.ProjectResponse;
import com.lovable.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import com.lovable.projects.lovable_clone.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
