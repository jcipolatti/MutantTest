package com.magneto.mutanttest.object;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.magneto.mutanttest.test.dnaTest;

public class Subject {
    private String[] dna;

    @JsonCreator
    public Subject(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna(){
        return dna;
    }

    public boolean isMutant(){
        return dnaTest.isMutant(dna);
    }
}
