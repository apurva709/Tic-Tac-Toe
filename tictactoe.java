/*
*PROJECT NAME:TicTacToe
*author:APURVA MEHTA
 */
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.*;

public class tictactoe{
    static Scanner input;
    static String[] board;
    static String turn="X";

    public static String BLUE = "\u001B[34m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";
    public static String colour = "\033[1;36m";
    static void printBoard()
            //to print board//
    {   System.out.println("-*-*-*-*-*-*-*-*-*-");
        System.out.println("|-----|-----|-----|");
        System.out.println("| " + board[0] + "   | " + board[1] + "   | " + board[2] + "   |");
        System.out.println("|-----|-----|-----|");
        System.out.println("| " + board[3] + "   | " + board[4] + "   | " + board[5] + "   |");
        System.out.println("|-----|-----|-----|");
        System.out.println("| " + board[6] + "   | " + board[7] + "   | " + board[8] + "   |");
        System.out.println("|-----|-----|-----|");
        System.out.println("-*-*-*-*-*-*-*-*-*-");
    }
    static void FillBoard()
    //to fill boards
    {
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a+1);
        }}

    static String checkWinner()
    //to check winners
    {
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> board[0] + board[1] + board[2];
                case 1 -> board[3] + board[4] + board[5];
                case 2 -> board[6] + board[7] + board[8];
                case 3 -> board[0] + board[3] + board[6];
                case 4 -> board[1] + board[4] + board[7];
                case 5 -> board[2] + board[5] + board[8];
                case 6 -> board[0] + board[4] + board[8];
                case 7 -> board[2] + board[4] + board[6];
                default -> null;
            };
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a+1))) {
                break;
            }
            else if (a == 8) return "draw";
        }

        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }


    public static void main(String[] args) {
         input =new Scanner(System.in);
        board = new String[9];
                String j;
        int point=0,point1=0;
        do {
        String winner = null;
        FillBoard();

        System.out.println(BLUE+"Welcome to 2 Player Tic Tac Toe.");

        printBoard();
        System.out.println("X's will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int numInput;
            try {
                numInput = input.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input please re-enter slot number:");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input please re-enter slot number:");
                continue;
            }
            if (board[numInput-1].equals(String.valueOf(numInput))) {
                board[numInput-1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                printBoard();
                winner = checkWinner();
            } else {
                System.out.println("Slot already fill re-enter slot number:");
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println(RED+"Congratulations!!! " + winner + "'s have won! \nThanks for playing.");
        }
        if (winner.equals("X"))
        {
           point++;
        }
        else if(winner.equals("O"))
        {
            point1++;
        }
        System.out.println(colour+"\t\tpoint of x is "+ point +"\n\t\tpoint of 0 is "+point1);
        System.out.println(GREEN+"want to play again!!!(y/n)");
        j= input.next();

    }while(!j.equalsIgnoreCase("n"));

      }}
