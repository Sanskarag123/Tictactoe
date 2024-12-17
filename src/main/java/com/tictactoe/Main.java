package com.tictactoe;


import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start the game: Y");
        String input ;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        if(!input.trim().equalsIgnoreCase("Y")) {
            System.out.println("Closing the game");
            return;
        }
        Board board = new Board();
        User user1 = User.createNewUser();
        User user2 = User.createNewUser();
        User lastUser = user1;
        int count = 0;
        while (!board.verifyBoard() && count != 9) {
            board.printBoard();
            if(lastUser == user1) {
                lastUser = user2;
            } else {
                lastUser = user1;
            }
            System.out.println("Add the position in format for user "+ lastUser.getName() +" : column row");
            int invalidCount = 3;
            String inputValues = scanner.nextLine();
            String[] splittedInput = inputValues.trim().split(" ");


            while(splittedInput.length != 2 && invalidCount != 0) {
                System.out.println("Invalid input, please re enter");
                inputValues = scanner.nextLine();
                splittedInput = inputValues.trim().split("_");
                invalidCount--;
            }
            if(invalidCount == 0) {
                System.out.println("Invalid entries are exausted, ending the game");
                return;
            }
            int c = Integer.parseInt(splittedInput[0]);
            int r = Integer.parseInt(splittedInput[1]);
            if(c>=3 || r >=3) {
                System.out.println("Invalid input ending the game.");
                return;
            }
            board.addPosition(c,r, lastUser);
            count++;
        }

        if(board.verifyBoard()) {
            board.printBoard();
            System.out.println("Winner is "+ lastUser.getName());
        } else{
            System.out.println("Match is a tie");
        }
    }

}