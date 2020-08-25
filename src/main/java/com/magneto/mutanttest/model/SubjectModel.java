package com.magneto.mutanttest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.magneto.mutanttest.test.dnaTest;

import javax.validation.constraints.Pattern;

public class SubjectModel {

    @Pattern(regexp = "[ACTG]+")
    private String dna;

    private boolean isMutant;

    @JsonCreator
    public SubjectModel(String[] dna){
        StringBuffer sf = new StringBuffer();
        for(int i = 0; i < dna.length; i++) {
            sf.append(dna[i]);
        }

        this.dna = sf.toString();
        this.isMutant = dnaTest.isMutant(dna);
    }

    public String getDna(){
        return dna;
    }

    public boolean isMutant(){
        return isMutant;
    }
}