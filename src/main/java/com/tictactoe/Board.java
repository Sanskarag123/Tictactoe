package com.tictactoe;

public class Board {

    int[][] boardMain;

    Board() {
        boardMain = new int[3][3];
    }

    public void addPosition(int column, int row, User user) {
        boardMain[column-1][row-1] = user.assignedSign;
    }

    public boolean verifyBoard() {
        int sumDig1 = 0;
        int sumDig2 = 0;
        for(int i=0;i<3;i++) {
            int sum1 = 0;
            int sum2 = 0;
            for(int j=0;j<3;j++) {
                sum1 += boardMain[i][j];
                sum2 += boardMain[j][i];
                if(i == j) {
                    sumDig1 += boardMain[i][j];
                }
                if(i == 3-(j+1)) {
                    sumDig2 += boardMain[i][j];
                }
            }
            if(sum1 != 0 && (sum1/3) == 'X' || (sum1/3) == 'O') {
                return true;
            }
            if(sum2 != 0 && (sum2/3) == 'X' || (sum2/3) == 'O') {
                return true;
            }
        }

        if(sumDig1 != 0 && (sumDig1/3) == 'X' || (sumDig1/3) == 'O') {
            return true;
        }
        if(sumDig2 != 0 && (sumDig2/3) == 'X' || (sumDig2/3) == 'O') {
            return true;
        }
        return false;
    }

    public void printBoard() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(j < 2)
                    System.out.print((char) boardMain[i][j] + " |");
                else
                    System.out.println((char) boardMain[i][j]);
            }
            if(i != 2)
                System.out.println("---------");
        }
    }
}
