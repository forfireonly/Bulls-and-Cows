package bullscows;

public class Grader {

    private String[] secreteCode;

    public String[] getSecreteCode(){
        return secreteCode;
    }

    public void setSecreteCode(String[] secreteCode) {
        this.secreteCode = secreteCode;
    }



    public boolean check(String[] guess) {
        int cows = 0;
        int bulls = 0;
        String answer = "";
        boolean isWon = false;


        //String secretCodeFour = secreteCode[0] + secreteCode[1] +
        //        secreteCode[2] +secreteCode[3];

        for (int i = 0; i < guess.length; i++) {
            if (guess[i].equals(secreteCode[i])) {
                bulls += 1;
            }
        }
        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < guess.length; j++) {
                if (i != j && secreteCode[i].equals(guess[j])) {
                    cows += 1;
                }
            }
        }
        if (bulls == 0 && cows != 0) {
            System.out.printf("Grade: %d cow(s).", cows);
            System.out.println();
        }else if (bulls == guess.length){
            System.out.printf("Grade: %d bull(s)", bulls);
            System.out.println();
            System.out.println("Congratulations! You guessed the secret code.");
            isWon = true;
        }  else if (bulls != 0 && cows == 0) {
            System.out.printf("Grade: %d bull(s).", bulls);
            System.out.println();
        } else if (bulls != 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s).", bulls, cows);
            System.out.println();
        } else {
            System.out.println("Grade: None.");
        }

        return isWon;

    }


}
