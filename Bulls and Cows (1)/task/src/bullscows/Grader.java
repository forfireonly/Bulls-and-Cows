package bullscows;

public class Grader {

    private String[] secreteCode;

    public String[] getSecreteCode(){
        return secreteCode;
    }

    public void setSecreteCode(String[] secreteCode) {
        this.secreteCode = secreteCode;
    }

    public void check(String[] guess) {
        int cows = 0;
        int bulls = 0;
        String answer = "";
        String secretCodeFour = secreteCode[0] + secreteCode[1] +
                secreteCode[2] +secreteCode[3];

        for (int i = 0; i < 4; i++) {
            if (guess[i].equals(secreteCode[i])) {
                bulls += 1;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j && secreteCode[i].equals(guess[j])) {
                    cows += 1;
                }
            }
        }
        if (bulls == 0 && cows != 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s", cows, secretCodeFour);
        } else if (bulls != 0 && cows == 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %s", bulls, secretCodeFour);
        } else if (bulls != 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s", bulls, cows, secretCodeFour);
        } else {
            System.out.println("Grade: None. The secret code is " + secretCodeFour);
        }

    }


}
