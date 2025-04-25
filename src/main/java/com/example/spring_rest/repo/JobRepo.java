package com.example.spring_rest.repo;

import com.example.spring_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

//    List<JobPost> jobs=new ArrayList<>(Arrays.asList(
//            new JobPost(1,"Java","Javava",12,List.of("java")),
//            new JobPost(2,"Python","Java",11,List.of("python")),
//            new JobPost(3,"CSharp","C#",13,List.of("C"))
//    ));
//    public List<JobPost> getAllJobs(){
//        return jobs;
//    }
//
//    public void addJob(JobPost jobPost){
//        jobs.add(jobPost);
//        System.out.println(jobs);
//    }
//
//    public JobPost getJob(int postId){
//        for(JobPost job:jobs){
//            if(job.getPostId()==postId){
//                return job;
//            }
//        }
//        return null;
//    }
//    public void updateJob(JobPost jobPost){
//        for(JobPost jobPost1:jobs){
//            if(jobPost1.getPostId()==jobPost.getPostId()){
//                jobPost1.setPostDesc(jobPost.getPostDesc());
//                jobPost1.setPostProfile(jobPost.getPostProfile());
//                jobPost1.setPostTechStack(jobPost.getPostTechStack());
//                jobPost1.setReqExperience((jobPost.getReqExperience()));
//            }
//        }
//    }
//
//    public void deleteJob(int postId){
//        for(JobPost jobPost:jobs){
//            if(jobPost.getPostId()==postId){
//                jobs.remove(jobPost);
//            }
//        }
//    }
}
