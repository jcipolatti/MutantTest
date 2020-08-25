package com.magneto.mutanttest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.magneto.mutanttest.test.dnaTest.isMutant;

@SpringBootTest
class MutantTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void horizontalTest() {
        String[] lines = {
                "ATGGGG",
                "TCACTG",
                "TTATGT",
                "AGAAGG",
                "TTCTGT",
                "CCCCTA"};
        Assertions.assertTrue(isMutant(lines));
    }

    @Test
    void verticalTest() {
        String[] lines = {
                "ATGCGA",
                "CAGTGC",
                "TTGTTG",
                "AGGAGG",
                "GCGTCG",
                "TCATTG"};
        Assertions.assertTrue(isMutant(lines));
    }

    @Test
    void diagonalUpTest() {
        String[] lines = {
                "ATGCGA",
                "CAGGGC",
                "TAGTCG",
                "AGTCGC",
                "GACTCG",
                "TCTTTG"};
        Assertions.assertTrue(isMutant(lines));
    }

    @Test
    void diagonalDownTest() {
        String[] lines = {
                "ATTCGA",
                "TAGTGC",
                "GAATTT",
                "AGTAGT",
                "GCTTCA",
                "TCAGCG"};
        Assertions.assertTrue(isMutant(lines));
    }
}
