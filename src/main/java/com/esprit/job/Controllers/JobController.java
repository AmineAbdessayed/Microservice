package com.esprit.job.Controllers;


import com.esprit.job.Entities.Job;
import com.esprit.job.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("job")
@RestController
public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)

    public ResponseEntity<Job> createJob(@RequestBody Job job){

        return  new ResponseEntity<>(jobService.AddJob(job), HttpStatus.OK);
    }


    @GetMapping("/jobs")
    public  ResponseEntity<List<Job> > getJobs(){

        List<Job> jobs= jobService.GetJobs();


        return ResponseEntity.ok(jobs);
    }



    @GetMapping("/service/{service}")
    public ResponseEntity<Job> getJobByService(@PathVariable String service) {
        Job job = jobService.GetJobbyService(service);
        if (job != null) {
            return ResponseEntity.ok(job);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id) {
       Optional<Job> job = jobService.GetJobByyId(id);
        return job.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PutMapping("/{id}/etat")
    public ResponseEntity<Job> updateJobEtat(@PathVariable Integer id, @RequestParam Boolean etat) {
        Job updatedJob = jobService.updateJob(id, etat);
        if (updatedJob != null) {
            return ResponseEntity.ok(updatedJob);
        } else {
            return ResponseEntity.notFound().build();
        }
    }












}
