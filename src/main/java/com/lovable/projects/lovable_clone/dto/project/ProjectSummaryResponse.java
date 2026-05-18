package com.lovable.projects.lovable_clone.dto.project;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id, // id of project
        String name, // name of the project
        Instant createdAt,
        Instant updatedAt
) {
}
