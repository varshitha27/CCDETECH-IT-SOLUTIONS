import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        char player = 'X';
        boolean humanVsComputer = chooseGameMode();
        initializeBoard();

        while (true) {
            printBoard();
            if ((player == 'O') && humanVsComputer) {
                computerMove();
            } else {
                playerMove(player);
            }
            if (isWinner(player)) {
                printBoard();
                System.out.println("Player " + player + " wins!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("The game is a draw!");
                break;
            }
            player = (player == 'X') ? 'O' : 'X';
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean chooseGameMode() {
        System.out.println("Choose game mode:\n1. Human vs Human\n2. Human vs Computer");
        int choice = scanner.nextInt();
        return choice != 1;
    }

    private static void playerMove(char player) {
        int row, col;
        while (true) {
            System.out.println("Player " + player + ", enter row and column (1-3):");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = player;
                break;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    private static void computerMove() {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != '-');
        System.out.println("Computer plays " + (row + 1) + " " + (col + 1));
        board[row][col] = 'O';
    }

    private static boolean isWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
