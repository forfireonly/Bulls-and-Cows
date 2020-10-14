package bullscows;

import java.util.Random;

public class RandomNumber {

    private int lengthOfNumber;
    private int numberOfSymbols;

    String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public void setLengthOfNumber(int lengthOfNumber) {
        this.lengthOfNumber = lengthOfNumber;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public String printBeforeTheGame() {
        String range = "";
        if (numberOfSymbols > 0) {
            range = ", (" + alphabet[0] + "-" + alphabet[numberOfSymbols] + ").";
        }
        return "The secret is prepared: " + "*".repeat(lengthOfNumber) + " (0-9" + range;
    }

    public String generatePseudoNumber() {
        StringBuilder secretNumber = new StringBuilder();
        Random rand = new Random();
        int rand_int = 0;

        boolean isNumber = false;
        int indexOfLetter = 0;
        String letter = "";
        if (lengthOfNumber > 36) {
            System.out.println("Error: can't generate a secret number with a length more than 36");
        } else if (numberOfSymbols <= 10) {
            for (int i = 0; i < lengthOfNumber; i++) {
                if (i == 0) {
                    while (rand_int == 0) {
                        rand_int = rand.nextInt(10);
                    }
                }

                while (secretNumber.toString().contains(String.valueOf(rand_int))) {
                    rand_int = rand.nextInt(10);
                }
                secretNumber.append(rand_int);
            }
        } else {
            for (int i = 0; i < lengthOfNumber; i++) {
                isNumber = rand.nextBoolean();
                if (isNumber) {
                    if (i == 0) {
                        while (rand_int == 0) {
                            rand_int = rand.nextInt(10);
                        }
                    }

                    while (secretNumber.toString().contains(String.valueOf(rand_int))) {
                        rand_int = rand.nextInt(10);
                    }
                    secretNumber.append(rand_int);
                } else {
                    indexOfLetter = rand.nextInt(numberOfSymbols);
                    letter = alphabet[indexOfLetter];
                    while (secretNumber.toString().contains(letter)) {
                        indexOfLetter = rand.nextInt(numberOfSymbols);
                        letter = alphabet[indexOfLetter];
                    }
                    secretNumber.append(letter);

                }
            }

        }
        System.out.println(secretNumber);
        return String.valueOf(secretNumber);
    }

    /*public String generatePseudoNumber() {
        String[] pseudoRandomNumber = String.valueOf(System.nanoTime()).split("");
        StringBuilder secretNumber = new StringBuilder();
        int index = pseudoRandomNumber.length - 1;

        if (lengthOfNumber > 10) {
            System.out.println("Error: can't generate a secret number with a length" +
                    " of 11 because there aren't enough unique digits.");
        } else {
            for (int i = 0; i < lengthOfNumber; i++) {
                while (i == 0 && pseudoRandomNumber[index].equals("0")) {
                    index = index - 1;
                }
                while (secretNumber.toString().contains(pseudoRandomNumber[index])) {
                    index = index - 1;
                }
                secretNumber.append(pseudoRandomNumber[index]);
                if (index == 0) {
                    pseudoRandomNumber = String.valueOf(System.nanoTime()).split("");
                    index = pseudoRandomNumber.length - 1;
                }
                index = index - 1;
            }
        }
        return String.valueOf(secretNumber);
    }*/
}
