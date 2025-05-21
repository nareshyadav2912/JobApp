package com.example.spring_rest.controller;

import com.example.spring_rest.model.JobPost;
import com.example.spring_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class JobRestController {


    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return jobService.getJob(postId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        jobService.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData(){
        jobService.load();
        return "Success";
    }
}
