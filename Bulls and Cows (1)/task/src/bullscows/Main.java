package bullscows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] guess = reader.readLine().split("");
        String[] someSecretCode = new String[]{"9","3","0","5"};
        Grader grader = new Grader();
        grader.setSecreteCode(someSecretCode);
        grader.check(guess);


    }
}
