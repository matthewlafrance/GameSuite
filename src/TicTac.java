import java.util.*;

public class TicTac {

    private char[][] squares;
    public char turn = 'O';
    public static final int SIZE = 3;
    
    public TicTac() {
        this.squares = new char[3][3];
        for (int i = 0; i < TicTac.SIZE; i++) {
            for (int j = 0; j < TicTac.SIZE; j++) {
                this.squares[i][j] = '.';
            }
        }
    }

    public static void play() {
        System.out.println("Welcome to tic tac toe");
        System.out.println("Please input your moves in the format rowcolumn, ex 02, and O always starts");

        TicTac game = new TicTac();
        Scanner input = new Scanner(System.in);

        game.printBoard();

        boolean gameOver = false;

        while(!gameOver) {
            String nextMove = input.next();
            while(!game.isValidMove(nextMove)) {
                System.out.println("Invalid move, please try again");
                nextMove = input.next();
            }
            game.makeMove(nextMove);
            gameOver = game.isOver(nextMove);
            game.printBoard();
        }
        System.out.println("Game Over " + game.oppositeTurn() + " wins");
    }

    public static int[] parseMove(String move) {
        if (move.length() != 2) {
            return null;
        }

        int[] coords = new int[2];
        coords[0] = (int)move.charAt(0) - '0';
        coords[1] = (int)move.charAt(1) - '0';
        return coords;
    }

    public char oppositeTurn() {
        if (this.turn == 'O') {
            return 'X';
        }else {
            return 'O';
        }
    }

    public boolean isValidMove(String move) {
        int[] coords = parseMove(move);

        if (this.squares[coords[0]][coords[1]] != '.' ) {
            return false;
        }

        return true;
    }

    public void makeMove(String move) {
        int[] coords = parseMove(move);
        this.squares[coords[0]][coords[1]] = this.turn;
        if (this.turn == 'O') {
            this.turn = 'X';
        } else {
            this.turn = 'O';
        }
    }

    public boolean isOver(String move) {
        int[] coords = parseMove(move);
        char cur = this.squares[coords[0]][coords[1]];
        boolean vertical = true;
        boolean horizontal = true;
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        for (int i = 0; i < this.SIZE; i++) {
            if (this.squares[coords[0]][i] != cur) {
                vertical = false;
            }
        }

        for (int i = 0; i < this.SIZE; i++) {
            if (this.squares[i][coords[1]] != cur) {
                horizontal = false;
            }
        }

        if (coords[0] == coords[1]) {
            for (int i = 0; i < this.SIZE; i++) {
                if (this.squares[i][i] != cur) {
                    diagonal1 = false;
                }
                if (this.squares[i][2-i] != cur) {
                    diagonal2 = false;
                }
            }
        } else {
            diagonal1 = false;
            diagonal2 = false;
        }
        return (vertical || horizontal) || (diagonal1 || diagonal2);
    }

    public void printBoard() {
        for (int i = 0; i < this.SIZE; i++) {
            for (int j = 0; j < this.SIZE; j++) {
                System.out.print(this.squares[i][j]);
            }
            System.out.println();
        }
    }
}