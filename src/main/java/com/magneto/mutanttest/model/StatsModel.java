package com.magneto.mutanttest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsModel {

    private final Long countMutantDna;
    private final Long countHumanDna;
    private final Double ratio;

    public StatsModel(Long countMutantDna, Long countHumanDna){
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
        this.ratio = (countHumanDna > 0)
            ? (double) countMutantDna / (double) countHumanDna
            : null;
    }

    @JsonProperty("count_mutant_dna")
    public Long getCountMutantDna() {
        return countMutantDna;
    }

    @JsonProperty("count_human_dna")
    public Long getCountHumanDna() {
        return countHumanDna;
    }

    @JsonProperty("ratio")
    public Double getRatio() {
        return ratio;
    }
}
