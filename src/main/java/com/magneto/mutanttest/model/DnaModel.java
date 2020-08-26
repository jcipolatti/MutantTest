package com.magneto.mutanttest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.magneto.mutanttest.test.dnaTest;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.Pattern;

@Entity
public class DnaModel {

    @Id
    @Pattern(regexp = "[ACTG]+")
    private String dna;

    private boolean isMutant;

    @JsonCreator
    public DnaModel(String[] dna){
        StringBuffer sf = new StringBuffer();
        for(int i = 0; i < dna.length; i++) {
            sf.append(dna[i]);
        }

        this.dna = sf.toString();
        this.isMutant = dnaTest.isMutant(dna);
    }

    public DnaModel() { }

    public String getDna() { return dna; }

    public boolean isMutant(){
        return isMutant;
    }
}
