package bullscows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        System.out.println("Please, enter the secret code's length:");

        String lengthOfCodeString = reader.readLine();
        if (!lengthOfCodeString.matches("-?\\d+")) {
            System.out.println("Error: " + lengthOfCodeString +" isn't a valid number.");
            System.exit(0);
        }

        int lengthOfCode = Integer.parseInt(lengthOfCodeString);
        String[] guessSecretCode = new String[lengthOfCode];

        System.out.println("Input the number of possible symbols in the code:");

        int numberOfSymbols = Integer.parseInt(reader.readLine());

        if (numberOfSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }

        Grader grader = new Grader();

        RandomNumber newRandomNumber = new RandomNumber();
        if (numberOfSymbols < lengthOfCode || lengthOfCode == 0) {
            System.out.println("Error: it's not possible to generate a code with a length of " + lengthOfCode +
                            "with" + numberOfSymbols + " unique symbols.");
            System.exit(0);
        }
        newRandomNumber.setLengthOfNumber(lengthOfCode);
        newRandomNumber.setNumberOfSymbols(numberOfSymbols - 11);
        String[] secretCode = newRandomNumber.generatePseudoNumber().split("");
        grader.setSecreteCode(secretCode);
        System.out.println(newRandomNumber.printBeforeTheGame());
        System.out.println("Okay, let's start a game!");
        boolean isGuessed = false;
        int turn = 1;

        while (!isGuessed) {
            System.out.println("Turn " + turn +":");
            guessSecretCode = reader.readLine().split("");
            isGuessed = grader.check(guessSecretCode);
            turn += 1;

        }
    }
}
