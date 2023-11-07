package com.esprit.job.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job  implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;


    @Column(name = "service")


    private  String service;

    @Column(name = "Etat")

    private  Boolean etat;


}
