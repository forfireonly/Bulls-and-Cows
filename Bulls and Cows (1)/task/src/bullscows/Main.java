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


        /*String[] guess = reader.readLine().split("");
        String[] someSecretCode = new String[]{"9","3","0","5"};
        Grader grader = new Grader();
        grader.setSecreteCode(someSecretCode);
        grader.check(guess);*/
        Grader grader = new Grader();


        RandomNumber newRandomNumber = new RandomNumber();
        newRandomNumber.setLengthOfNumber(lengthOfCode);
        String[] secretCode = newRandomNumber.generatePseudoNumber().split("");
        grader.setSecreteCode(secretCode);
        System.out.println("Okay, let's start a game!");
        boolean isGuessed = false;
        int turn = 1;
        //grader

        while (!isGuessed) {
            System.out.println("Turn " + turn +":");
            guessSecretCode = reader.readLine().split("");
            isGuessed = grader.check(guessSecretCode);
            turn += 1;



        }


    }
}
