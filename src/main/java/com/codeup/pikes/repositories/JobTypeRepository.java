package com.codeup.pikes.repositories;

import com.codeup.pikes.models.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType, Long> {
}
