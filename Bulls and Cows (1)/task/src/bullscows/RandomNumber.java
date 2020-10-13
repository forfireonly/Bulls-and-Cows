package bullscows;

public class RandomNumber {

    private int lengthOfNumber;
    private long pseudoRandomNumberCode;

    public void setLengthOfNumber(int lengthOfNumber) {
        this.lengthOfNumber = lengthOfNumber;
    }

    public long getPseudoRandomNumber() {
        return pseudoRandomNumberCode;
    }

    public void generatePseudoNumber() {
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
            System.out.printf("The random secret number is %s.", secretNumber);
        }


    }
}
