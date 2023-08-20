package LeetCode;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {
    static String[] board;
    static String turn;

    static String checkWinner() {
        for (int chance = 0; chance < 8; chance++) {
            String line = null;

            switch (chance) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            // for X winner

            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            } else if (i == 8) {
                return "draw";
            }
        }

        System.out.println(turn + " 's turn. Enter slot number to place " + turn + " in : ");
        return null;
    }

    static void ticTacToeBoard() {
        System.out.println();
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
        System.out.println();
    }

    public static void startGame() {
        Scanner s = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }

        System.out.println("Welcome to TicTacToe Game");
        ticTacToeBoard();

        System.out.println("X will play first. Enter a slot number to place X in : ");

        while (winner == null) {
            int numInput;

            try {
                numInput = s.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid Input! Re-Enter slot number : ");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Re-Enter slot number : ");
                continue;
            }

            if (board[numInput - 1].equals(String.valueOf(numInput))) {
                board[numInput - 1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }

                ticTacToeBoard();
                winner = checkWinner();
            } else {
                System.out.println("Slot already taken, reenter slot number : ");
            }
        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have Won.");
        }
        s.close();
    }
}
