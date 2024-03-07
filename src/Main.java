import java.util.regex.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String games = "Tic-Tac-Toe, Chess, 2048";
        System.out.println("Welcome to Matthew's GameSuite");

        Scanner input = new Scanner(System.in);
        String game = promptFor("Start a new game with `new`, or load an existing one with `load`", input);

        while (!(game.toLowerCase().equals("load") || game.toLowerCase().equals("new"))) {
            game = promptFor("Please input either \'new\' or \'load\'", input);
        } 

        if (game.toLowerCase().equals("load")) {
            game = promptFor("Please input the name of your loaded game file", input);
            boolean validFile = false;
            while (!validFile) {
                try {
                    BufferedReader in = new BufferedReader(new FileReader(game));
                    String gameName = in.readLine();
                    String gameState = in.readLine();
                    if (gameName.equals("chess")) {
                        Chess.play();
                    } else if (gameName.equals("2048")) {
                        tfe.play();
                    } else if (gameName.equals("ticTacToe")) {
                        TicTac.play();
                    } else {
                        game = promptFor("Invalid game name, please try again", input);
                        continue;
                    }
                    validFile = true;
                } catch (FileNotFoundException e) {
                    game = promptFor("Invalid file name, please try again", input);
                } catch (IOException e) {
                    System.out.println("Failed to read file");
                    System.exit(1);
                }
            }
        } else {
            game = promptFor("Please choose your game, current options are " + games, input);
            game.toLowerCase();
            System.out.println(game);
            boolean played = false;
            while (!played) {
                if (game.equalsIgnoreCase("Chess")) {
                        Chess.play();
                        played = true;
                } else if (game.equals("2048")) {
                        tfe.play();
                        played = true;
                } else if (Pattern.matches("[tT]ic[- ]?[Tt]ac[- ]?[Tt]oe", game)) {
                        TicTac.play();
                        played = true;
                } else {
                    game = promptFor("invalid game choice, please make sure input matches options exactly", input);
                }
            }
        }
    }

    public static String promptFor(String prompt, Scanner input) {
        System.out.println(prompt);
        System.out.print("> ");
        return input.nextLine();
    }
}