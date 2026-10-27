package com.jobportal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.ApplicationDTO;
import com.jobportal.entity.Application;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;

@RestController
@CrossOrigin
public class ApplicationController {
    
    @Autowired
    private ApplicationRepository repo;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private JobRepository jobRepo;
    
    // for apply job
    @PostMapping("/apply")
    public String apply(@RequestParam int userId ,
        @RequestParam int jobId) 
    {
        boolean exeist = repo.existsByUserIdAndJobId(userId, jobId);
        
        if(exeist) {
            return "alredy applied";
        }
        Application a= new Application();
        a.setUserId(userId);
        a.setJobId(jobId);
        
        repo.save(a);
    return "Applied Sucessfully!";
    }
    
    
    // with dto
    @GetMapping("/applications/details")
    public List<ApplicationDTO> getDetails(){
        
        List<Application> list = repo.findAll();
        
        List<ApplicationDTO> result  = new ArrayList<>();
        
        for(Application a: list) {
        String name = 
        userRepo.findById(a.getUserId()).get().getName();
        
        String job = 
        jobRepo.findById(a.getJobId()).get().getTitle();
        
        result.add(new ApplicationDTO(name, job));
        }
        return result;
    }
    
}