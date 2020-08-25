package com.magneto.mutanttest.test;

public class dnaTest {
    public static boolean isMutant(String[] dna) {
        char[][] dnaMap = new char[6][6];
        int sequencesFound = 0;

        for (int i = 0; i < 6; i++) {
            dnaMap[i] = dna[i].toCharArray();
        }

        //Horizontal and Vertical
        for (int j = 0; j < 6; j++){
            int hCount = 0;
            int vCount = 0;
            for (int i = 0; i < 5; i++){
                //Horizontal pattern check
                hCount = (dnaMap[j][i] == dnaMap[j][i + 1])
                    ? hCount + 1
                    : 0;
                if (hCount == 3){
                    sequencesFound++;
                    hCount = 0;
                }
                //Vertical pattern check
                vCount = (dnaMap[i][j] == dnaMap[i + 1][j])
                        ? vCount + 1
                        : 0;
                if (vCount == 3) {
                    sequencesFound++;
                    vCount = 0;
                }
            }
        }

        //Diagonal
        for (int l = 0; l < 3; l++){
            int ddCount = 0;
            int duCount = 0;
            int i = l;
            int j = 0;
            int k = 5;
            while (i < 5) {
                //Diagonal Down pattern check [0.0][1.0][2.0]
                ddCount = (dnaMap[i][j] == dnaMap[i + 1][j + 1])
                        ? ddCount + 1
                        : 0;
                if (ddCount == 3) {
                    sequencesFound++;
                    ddCount = 0;
                }
                //Diagonal Up pattern check [5.0][5.1][5.2]
                duCount = (dnaMap[k][i] == dnaMap[k - 1][i + 1])
                        ? duCount + 1
                        : 0;
                if (duCount == 3) {
                    sequencesFound++;
                    duCount = 0;
                }
                k--;
                j++;
                i++;
            }
        }
        //Diagonal Down [0.1][0.2]
        for (int k = 1; k < 3; k++){
            int ddCount = 0;
            int i = 0;
            int j = k;
            while (j < 5) {
                ddCount = (dnaMap[i][j] == dnaMap[i + 1][j + 1])
                        ? ddCount + 1
                        : 0;
                if (ddCount == 3) {
                    sequencesFound++;
                    ddCount = 0;
                }
                i++;
                j++;
            }
        }
        //Diagonal Up [3.0][4.0]
        for (int k = 3; k < 5; k++){
            int duCount = 0;
            int i = 0;
            int j = k;
            while (j > 0) {
                duCount = (dnaMap[j][i] == dnaMap[j - 1][i + 1])
                        ? duCount + 1
                        : 0;
                if (duCount == 3) {
                    sequencesFound++;
                    duCount = 0;
                }
                i++;
                j--;
            }
        }

        return sequencesFound >= 2;
    }
}
