package com.example.spring_rest.service;

import com.example.spring_rest.model.JobPost;
import com.example.spring_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost){
        //jobRepo.addJob(jobPost);
        jobRepo.save(jobPost);
    }
    public List<JobPost> getAllJobs(){
        //return jobRepo.getAllJobs();
        return jobRepo.findAll();
    }

    public JobPost getJob(int postId){
        //return jobRepo.getJob(postId);
        return jobRepo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost){
        //jobRepo.updateJob(jobPost);
        jobRepo.save(jobPost);
    }

    public void deleteJob(int postId) {
        //jobRepo.deleteJob(postId);
        jobRepo.deleteById(postId);
    }

    public void load(){
        List<JobPost> jobs=new ArrayList<>(Arrays.asList(
            new JobPost(1,"Java","Javava",12,List.of("java")),
            new JobPost(2,"Python","Java",11,List.of("python")),
            new JobPost(3,"CSharp","C#",13,List.of("C"))
    ));
        jobRepo.saveAll(jobs);
    }
}
