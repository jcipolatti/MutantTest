package com.magneto.mutanttest.test;

public class dnaTest {
    @SuppressWarnings("DuplicatedCode")
    public static boolean isMutant(String[] dna) {
        char[][] dnaMap = new char[6][6];
        int sequencesFound = 0;

        for (int i = 0; i < 6; i++) {
            dnaMap[i] = dna[i].toCharArray();
        }

        int count = 0; //Pattern pair count.

        //Horizontal and Vertical test
        for (int i = 0; i < 6; i++){
            int hCount = 0;
            int vCount = 0;
            for (int j = 0; j < 5; j++){
                //Horizontal pattern check
                hCount = (dnaMap[i][j] == dnaMap[i][j + 1])
                    ? hCount + 1
                    : 0;
                if (hCount == 3){
                    sequencesFound++;
                    hCount = 0;
                }
                //Vertical pattern check
                vCount = (dnaMap[j][i] == dnaMap[j + 1][i])
                        ? vCount + 1
                        : 0;
                if (vCount == 3) {
                    sequencesFound++;
                    vCount = 0;
                }
            }
        }
        //Diagonal down
        for (int k = 1; k < 3; k++){
            count = 0;
            int i = k;
            int j = 0;
            while (i < 5) {
                count = (dnaMap[i][j] == dnaMap[i + 1][j + 1])
                        ? count + 1
                        : 0;
                if (count == 3) {
                    sequencesFound++;
                    count = 0;
                }
                i++;
                j++;
            }
        }
        for (int k = 0; k < 3; k++){
            count = 0;
            int i = 0;
            int j = k;
            while (j < 5) {
                count = (dnaMap[i][j] == dnaMap[i + 1][j + 1])
                        ? count + 1
                        : 0;
                if (count == 3) {
                    sequencesFound++;
                    count = 0;
                }
                i++;
                j++;
            }
        }
        //Diagonal up
        for (int k = 1; k < 3; k++){
            count = 0;
            int i = k;
            int j = 5;

            while (i < 5) {
                count = (dnaMap[j][i] == dnaMap[j - 1][i + 1])
                        ? count + 1
                        : 0;
                if (count == 3) {
                    sequencesFound++;
                    count = 0;
                }
                i++;
                j--;
            }
        }
        for (int k = 3; k < 6; k++){
            count = 0;
            int i = 0;
            int j = k;
            while (j > 0) {
                count = (dnaMap[j][i] == dnaMap[j - 1][i + 1])
                        ? count + 1
                        : 0;
                if (count == 3) {
                    sequencesFound++;
                    count = 0;
                }
                i++;
                j--;
            }
        }
        /*//Diagonal up
        for (int k = 3; k < 6; k++){
            count = 0;
            int i = k;
            int j = 0;
            while (i > 0) {
                count = (dnaMap[i][j] == dnaMap[i - 1][j + 1])
                        ? count + 1
                        : 0;
                if (count == 3) {
                    sequencesFound++;
                    count = 0;
                }
                i--;
                j++;
            }
        }
        for (int k = 1; k < 3; k++){
            count = 0;
            int i = 5;
            int j = k;
            while (j < 5) {
                count = (dnaMap[i][j] == dnaMap[i - 1][j + 1])
                        ? count + 1
                        : 0;

                if (count == 3) {
                    sequencesFound++;
                    count = 0;
                }
                i--;
                j++;
            }
        }

        //Diagonal down
        for (int k = 1; k < 3; k++){
            count = 0;
            int i = k;
            int j = 0;
            while (i < 5) {
                count = (dnaMap[i][j] == dnaMap[i + 1][j + 1])
                        ? count + 1
                        : 0;
                if (count == 3) {
                    sequencesFound++;
                    count = 0;
                }
                i++;
                j++;
            }
        }
        for (int k = 0; k < 3; k++){
            count = 0;
            int i = 0;
            int j = k;
            while (j < 5) {
                count = (dnaMap[i][j] == dnaMap[i + 1][j + 1])
                        ? count + 1
                        : 0;

                if (count == 3) {
                    sequencesFound++;
                    count = 0;
                }
                i++;
                j++;
            }
        }*/

        return sequencesFound >= 2;
    }
}
