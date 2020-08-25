package com.magneto.mutanttest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubjectEntity {

    @Id
    private String dnaChain;

    private boolean isMutant;

    public SubjectEntity() {
    }

    public SubjectEntity(String[] dna, boolean isMutant){

        StringBuffer dnaChain = new StringBuffer();
        for(int i = 0; i < dna.length; i++) {
            dnaChain.append(dna[i]);
        }

        this.dnaChain = dnaChain.toString();
        this.isMutant = isMutant;

    }
}
