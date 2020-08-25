package com.magneto.mutanttest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.magneto.mutanttest.test.dnaTest;

public class SubjectModel {
    private String[] dna;
    private boolean isMutant;

    @JsonCreator
    public SubjectModel(String[] dna){
        this.dna = dna;
        this.isMutant = dnaTest.isMutant(dna);
    }

    public String[] getDna(){
        return dna;
    }

    public boolean isMutant(){
        return isMutant;
    }
}
