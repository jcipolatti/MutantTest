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

        //Horizontal
        for (int i = 0; i < 6; i++){
            count = 0;
            for (int j = 0; j < 5; j++){
                count = (dnaMap[i][j] == dnaMap[i][j + 1])
                    ? count + 1
                    : 0;
                if (count == 3){
                    sequencesFound++;
                    count = 0;
                }
            }
        }

        //Vertical
        for (int i = 0; i < 6; i++) {
            count = 0;
            for (int j = 0; j < 5; j++) {
                count = (dnaMap[j][i] == dnaMap[j + 1][i])
                        ? count + 1
                        : 0;
                if (count == 3) {
                    sequencesFound++;
                    count = 0;
                }
            }
        }

        //Diagonal up
        for (int k = 3; k <= 5; k++){
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
        for (int k = 1; k <= 2; k++){
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
        for (int k = 2; k >= 0; k--){
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
        for (int k = 1; k <= 2; k++){
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

        return sequencesFound >= 2;
    }
}
