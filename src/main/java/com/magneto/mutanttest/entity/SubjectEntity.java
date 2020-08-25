package com.magneto.mutanttest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubjectEntity {

    @Id
    private String dna;

    private boolean isMutant;

    public SubjectEntity() {
    }

    public SubjectEntity(String dna, boolean isMutant){

        this.dna = dna;
        this.isMutant = isMutant;

    }
}
