package com.esprit.job.Repository;

import com.esprit.job.Entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {

    Job  findByService(String service);

}
