package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.jobportal.entity.Job;
import com.jobportal.repository.JobRepository;

@RestController
@CrossOrigin
public class JobController {

    @Autowired
    private JobRepository repo;

    // Add Job
    @PostMapping("/jobs")
    public String addJob(@RequestBody Job job) {

        System.out.println("Title : " + job.getTitle());
        System.out.println("Company : " + job.getCompany());
        System.out.println("Location : " + job.getLocation());
        System.out.println("Salary : " + job.getSalary());
        System.out.println("Image URL : " + job.getImageUrl());
        System.out.println("Description : " + job.getDescription());

        repo.save(job);

        return "Job Added Successfully";
    }

    // Get Jobs with Pagination
    @GetMapping("/jobs")
    public Page<Job> getJobs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return repo.findAll(PageRequest.of(page, size));
    }

    // Delete Job
    @DeleteMapping("/jobs/{id}")
    public String deleteJob(@PathVariable int id) {

        repo.deleteById(id);

        return "Deleted Successfully";
    }
}
