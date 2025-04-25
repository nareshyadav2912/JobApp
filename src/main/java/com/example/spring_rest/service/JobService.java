package com.example.spring_rest.service;

import com.example.spring_rest.model.JobPost;
import com.example.spring_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost){
        jobRepo.addJob(jobPost);
    }
    public List<JobPost> getAllJobs(){
        return jobRepo.getAllJobs();
    }

    public JobPost getJob(int postId){
        return jobRepo.getJob(postId);
    }

    public void updateJob(JobPost jobPost){
        jobRepo.updateJob(jobPost);
    }
}
