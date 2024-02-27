import java.util.regex.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String games = "Tic-Tac-Toe, Chess, 2048";
        System.out.println("Welcome to Matthew's GameSuite");
        System.out.println("Please choose your game, current options are " + games);
        Scanner input = new Scanner(System.in);
        String game = input.nextLine();
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
                System.out.println("invalid game choice, please make sure input matches options exactly");
                game = input.nextLine();
            }
        }
    }
}