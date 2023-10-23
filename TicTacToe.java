import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        // Hrací plocha
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Loop pro hru
            boardPrint(board);
            System.out.println("Zadej svůj tah tah 1-9:");
            playerTurn(board, scanner);
            if (hasGameEnded(board, 'X')) {
                break;
            }
            computerTurn(board);
            if (hasGameEnded(board, 'O')) {
                break;
            }
        }
        scanner.close();

    }

    private static void playerTurn(char[][] board, Scanner scanner) {
        // Získá číslo na tah hráče

        while (true) {
            try {
                int playerMove = scanner.nextInt();
                if (isValidMove(board, playerMove)) {
                    playMove(board, playerMove, 'X');
                    break;
                } else {
                    System.out.println("Na tuto pozici není možno zahrát!");
                }
            }catch (InputMismatchException ex) {
                System.out.println("Zadaná hodnota není číslo!");
            }
        }
    }

    private static void computerTurn(char[][] board) {
        // Vygeneruje číslo na tah počítače
        Random random = new Random();
        int computerMove;

        do {
            computerMove = random.nextInt(9) + 1;
        } while (!isValidMove(board, computerMove));

        playMove(board, computerMove, 'O');
    }

    private static boolean isValidMove (char[][] board, int position) {
        // Kontroluje zda je pozice tahu volná
        return switch (position) {
            case 1 -> (board[0][0] == ' ');
            case 2 -> (board[0][1] == ' ');
            case 3 -> (board[0][2] == ' ');
            case 4 -> (board[1][0] == ' ');
            case 5 -> (board[1][1] == ' ');
            case 6 -> (board[1][2] == ' ');
            case 7 -> (board[2][0] == ' ');
            case 8 -> (board[2][1] == ' ');
            case 9 -> (board[2][2] == ' ');
            default -> false;
        };
    }

    private static boolean hasGameEnded(char[][] board, char playSymbol) {
        // Kontroluje zda hra skončila
        if (board[0][0] == playSymbol && board[0][1] == playSymbol && board[0][2] == playSymbol ||
            board[1][0] == playSymbol && board[1][1] == playSymbol && board[1][2] == playSymbol ||
            board[2][0] == playSymbol && board[2][1] == playSymbol && board[2][2] == playSymbol ||
            board[0][0] == playSymbol && board[1][0] == playSymbol && board[2][0] == playSymbol ||
            board[0][1] == playSymbol && board[1][1] == playSymbol && board[2][1] == playSymbol ||
            board[0][2] == playSymbol && board[1][2] == playSymbol && board[2][2] == playSymbol ||
            board[0][0] == playSymbol && board[1][1] == playSymbol && board[2][2] == playSymbol ||
            board[2][0] == playSymbol && board[1][1] == playSymbol && board[0][2] == playSymbol) {
            boardPrint(board);
            if (playSymbol == 'X') {
                System.out.println("Vyhrál jsi!");
            } else {
                System.out.println("Prohrál jsi!");
            }
            return true;
        }
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        boardPrint(board);
        System.out.println("Hra skončila remízou!");
        return true;
    }

    private static void playMove(char[][] board, int input, char playSymbol){
        // Zahraje tah hráče/počítače na místo na hrací ploše
        switch(input){
            case 1:
                board[0][0] = playSymbol;
                break;
            case 2:
                board[0][1] = playSymbol;
                break;
            case 3:
                board[0][2] = playSymbol;
                break;
            case 4:
                board[1][0] = playSymbol;
                break;
            case 5:
                board[1][1] = playSymbol;
                break;
            case 6:
                board[1][2] = playSymbol;
                break;
            case 7:
                board[2][0] = playSymbol;
                break;
            case 8:
                board[2][1] = playSymbol;
                break;
            case 9:
                board[2][2] = playSymbol;
                break;
            default:
                System.out.println(":(");
        }
        if (playSymbol == '0') {
            boardPrint(board);
        }
    }

    public static void boardPrint(char[][] board){
        //Vytiskne hrací plochu
        System.out.println("╔" + "═" + "╦" + "═" + "╦" + "═" + "╗");
        System.out.println("║" + board[0][0] + "║" + board[0][1] + "║" + board[0][2] + "║");
        System.out.println("╠" + "═" + "╬" + "═" + "╬" + "═" + "╣");
        System.out.println("║" + board[1][0] + "║" + board[1][1] + "║" + board[1][2] + "║");
        System.out.println("╠" + "═" + "╬" + "═" + "╬" + "═" + "╣");
        System.out.println("║" + board[2][0] + "║" + board[2][1] + "║" + board[2][2] + "║");
        System.out.println("╚" + "═" + "╩" + "═" + "╩" + "═" + "╝");
    }
}