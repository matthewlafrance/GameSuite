import java.util.*;

public class tfe {
    private int[] squares;
    private int score;

    public tfe() {
        this.squares = new int[16];
        this.score = 0;
    }

    public static void play() {
        System.out.println("Welcome to 2048");
        System.out.println("Please use W A S D for up, left, down, and right respectively");

        tfe board = new tfe();
        board.addSquare();
        board.addSquare();
        board.printBoard();
        Scanner input = new Scanner(System.in);
        boolean gameNotOver = true;
        System.out.println();
        while (gameNotOver) {
            String move = input.next();
            System.out.println("Score: " + board.getScore() + "\n");
            while (board.isValidMove(move)) {
                System.out.println("invalid move please try again");
                move = input.next();
            }
            board.makeMove(move);
            board.addSquare();
            board.printBoard();
            gameNotOver = !board.isGameOver();
            System.out.println();
        }
        System.out.println("Game Over. Your score is " + board.getScore());
    }

    public boolean equals(Object obj) {
        tfe board = (tfe)obj;
        for (int i = 0; i < 16; i++) {
            if (board.squares[i] != this.squares[i]) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {

        int max = 1;

        for (int i = 0; i < 16; i++) {
            String num = this.squares[i] + "";
            if (num.length() > max) {
                max = num.length();
            }
        }

        for (int i = 0; i < 16; i++) {
            if (this.squares[i] == 0) {
                System.out.format("%" + max + "s", ".");
            } else {
                System.out.format("%" + max + "d", this.squares[i]);
            }
            System.out.print(" ");
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
    }

    public void addSquare() {
        int numEmpty = 0;
        for (int i = 0; i < 16; i++) {
            if (this.squares[i] == 0) {
                numEmpty++;
            }
        }

        int[] empty = new int[numEmpty];
        int counter = 0;

        for (int i = 0; i < 16; i++) {
            if (this.squares[i] == 0) {
                empty[counter] = i;
                counter++;
            }
        }
        
        int newSquare = (int)(Math.random() * numEmpty);
        int isFour = (int)(Math.random() * 10);
        int newSq = 2;

        if (isFour == 0) {
            newSq = 4;
        }

        this.squares[empty[newSquare]] = newSq;
    }

    public void makeMove(String move) {
        move.toLowerCase();
        if (move.equals("a")) {
            for (int i = 0; i < 4; i++) {

                int counter = 0;

                for (int j = i*4; j < i*4 + 4; j++) {
                    if (this.squares[j] != 0) {
                        counter++;
                    }
                }

                int[] nums = new int[counter];

                counter = 0;

                for (int j = i*4; j < i*4 + 4; j++) {
                    if (this.squares[j] != 0) {
                        nums[counter] = squares[j];
                        counter++;
                        squares[j] = 0;
                    }
                }

                for (int j = 0; j < nums.length - 1; j++) {
                    if (nums[j] == nums[j + 1]) {
                        nums[j] *= 2;
                        score += nums[j];
                        nums[j + 1] = 0;
                    }
                }

                counter = i * 4;

                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        this.squares[counter] = nums[j];
                        counter++;
                    }
                }
            }
        }

        if (move.equals("d")) {
            for (int i = 0; i < 4; i++) {

                int counter = 0;

                for (int j = i*4; j < i*4 + 4; j++) {
                    if (this.squares[j] != 0) {
                        counter++;
                    }
                }

                int[] nums = new int[counter];

                counter = 0;

                for (int j = i*4; j < i*4 + 4; j++) {
                    if (this.squares[j] != 0) {
                        nums[counter] = squares[j];
                        counter++;
                        squares[j] = 0;
                    }
                }

                for (int j = nums.length - 1; j >= 1; j--) {
                    if (nums[j] == nums[j - 1]) {
                        nums[j] *= 2;
                        score += nums[j];
                        nums[j - 1] = 0;
                    }
                }

                counter = i * 4 + 3;

                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] != 0) {
                        this.squares[counter] = nums[j];
                        counter--;
                    }
                }
            }
        }

        if (move.equals("w")) {
            for (int i = 0; i < 4; i++) {

                int counter = 0;

                for (int j = i; j < 13 + i; j+=4) {
                    if (this.squares[j] != 0) {
                        counter++;
                    }
                }

                int[] nums = new int[counter];

                counter = 0;

                for (int j = i; j < 13 + i; j+=4) {
                    if (this.squares[j] != 0) {
                        nums[counter] = squares[j];
                        counter++;
                        squares[j] = 0;
                    }
                }

                for (int j = 0; j < nums.length - 1; j++) {
                    if (nums[j] == nums[j + 1]) {
                        nums[j] *= 2;
                        score += nums[j];
                        nums[j + 1] = 0;
                    }
                }

                counter = i ;

                for (int j = 0; j < nums.length ; j++) {
                    if (nums[j] != 0) {
                        this.squares[counter] = nums[j];
                        counter += 4;
                    }
                }
            }
        }

        if (move.equals("s")) {
            for (int i = 0; i < 4; i++) {

                int counter = 0;

                for (int j = i; j < 13 + i; j+=4) {
                    if (this.squares[j] != 0) {
                        counter++;
                    }
                }

                int[] nums = new int[counter];

                counter = 0;

                for (int j = i; j < 13 + i; j+=4) {
                    if (this.squares[j] != 0) {
                        nums[counter] = squares[j];
                        counter++;
                        squares[j] = 0;
                    }
                }

                for (int j = nums.length - 1; j >=1; j--) {
                    if (nums[j] == nums[j - 1]) {
                        nums[j] *= 2;
                        score += nums[j];
                        nums[j - 1] = 0;
                    }
                }

                counter = i + 12;

                for (int j = nums.length - 1; j >= 0 ; j--) {
                    if (nums[j] != 0) {
                        this.squares[counter] = nums[j];
                        counter -= 4;
                    }
                }
            }
        }
    }

    public boolean isValidMove(String s) {
        tfe copyLeft = this.copy();
        copyLeft.makeMove(s);
        if (!copyLeft.equals(this)) {
            return false;
        }
        return true;
    }

    public boolean isGameOver() {
        tfe copyLeft = this.copy();
        copyLeft.makeMove("a");
        if (!copyLeft.equals(this)) {
            return false;
        }

        tfe copyRight = this.copy();
        copyRight.makeMove("d");
        if (!copyRight.equals(this)) {
            return false;
        }

        tfe copyUp = this.copy();
        copyUp.makeMove("w");
        if (!copyUp.equals(this)) {
            return false;
        }

        tfe copyDown = this.copy();
        copyDown.makeMove("a");
        if (!copyDown.equals(this)) {
            return false;
        }
        return true;
    }

    public tfe copy() {
        int[] copy = new int[16];
        for (int i = 0; i < 16; i++) {
            copy[i] = this.squares[i];
        }
        tfe board = new tfe();
        for (int i = 0; i < 16; i++) {
            board.squares[i] = copy[i];
        }
        return board;
    }

    public int getScore() {
        return this.score;
    }
}