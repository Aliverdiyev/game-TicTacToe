import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe!");
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        printBoard(board);
        while (true) {
            playerTurn(board, scanner);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
            computerTurn(board);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
        }
        scanner.close();

    }

    public static boolean isGameFinished(char[][] board) {
        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("You win!");
            return true;
        } else if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("Computer won!");
            return true;
        } else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == ' ') {
                        return false;
                    }
                }
            }
            printBoard(board);
            System.out.println("It's a tie!");
            return true;
        }
    }
//    Would you like to play again? (Y/N)

    public static boolean hasContestantWon(char[][] board, char symbol) {
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
                (board[2][2] == symbol && board[2][1] == symbol && board[2][0] == symbol) ||
                (board[2][0] == symbol && board[1][0] == symbol && board[0][0] == symbol) ||
                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol);
    }

    private static void computerTurn(char[][] board) {
        Random random = new Random();
        int computerMove;
        do {
            computerMove = random.nextInt(1, 9);
        } while (!isValidMove(board, Integer.toString(computerMove)));
        System.out.println("Computer choose: " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    public static boolean isValidMove(char[][] board, String position) {
        return switch (position) {
            case "1" -> (board[0][0] == ' ');
            case "2" -> (board[0][1] == ' ');
            case "3" -> (board[0][2] == ' ');
            case "4" -> (board[1][0] == ' ');
            case "5" -> (board[1][1] == ' ');
            case "6" -> (board[1][2] == ' ');
            case "7" -> (board[2][0] == ' ');
            case "8" -> (board[2][1] == ' ');
            case "9" -> (board[2][2] == ' ');
            default -> false;
        };
    }

    public static void playerTurn(char[][] board, Scanner scanner) {
        String playerMove;
        while (true) {
            System.out.println("Would you like to play? (1-9)");
            playerMove = scanner.nextLine();
            if (isValidMove(board, playerMove)) {
                break;
            } else {
                System.out.println(playerMove + " is not a valid move");
            }
        }
        placeMove(board, playerMove, 'X');
    }

    public static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}
