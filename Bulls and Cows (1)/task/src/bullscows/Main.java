package bullscows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        System.out.println("Please, enter the secret code's length:");

        int lengthOfCode = Integer.parseInt(reader.readLine());
        String[] guessSecretCode = new String[lengthOfCode];

        System.out.println("Input the number of possible symbols in the code:");

        int numberOfSymbols = Integer.parseInt(reader.readLine()) - 11;

        Grader grader = new Grader();

        RandomNumber newRandomNumber = new RandomNumber();
        newRandomNumber.setLengthOfNumber(lengthOfCode);
        newRandomNumber.setNumberOfSymbols(numberOfSymbols);
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
