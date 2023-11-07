package com.esprit.job.Services;

import com.esprit.job.Entities.Job;
import com.esprit.job.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JobService {


    @Autowired
    private JobRepository jobRepository;


    public Job AddJob(Job job) {

        return jobRepository.save(job);
    }

    public List<Job> GetJobs() {

        return jobRepository.findAll();
    }


    public Job GetJobbyService(String service) {

        return jobRepository.findByService(service);
    }


    public Optional<Job> GetJobByyId(Integer id) {

        return jobRepository.findById(id);
    }


    public Job updateJob(int id, Boolean etat) {
        if (jobRepository.findById(id).isPresent()) {
            Job existantJob = jobRepository.findById(id).get();
            existantJob.setEtat(etat);

            return jobRepository.save(existantJob);
        } else {
            return null;
        }

    }
}
