package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entity.Application;

public interface ApplicationRepository 
extends JpaRepository<Application, Integer>
{
    boolean existsByUserIdAndJobId(int userId , int jobId);
}
