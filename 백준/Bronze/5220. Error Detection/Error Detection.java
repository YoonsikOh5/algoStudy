import java.util.Scanner;

public class Main {

    /* Given a value and a checkbit, return "true" if the check bit matches
     * up with the "value", and "false" otherwise. */
    private static boolean solveErrorDetection(int value, int checkbit) {
        boolean valid = false;

        /* ------------------- INSERT CODE HERE ---------------------*/
        int cnt = 0;
            while (value > 0){
                int mod = value % 2;
                if(mod == 1){
                    cnt++;
                }
                value /= 2;
            }
            int resbit = 0;
            if(cnt % 2 == 0){
                resbit = 0;
            } else {
                resbit = 1;
            }
            if(resbit == checkbit){
                valid = true;
            } else {
                valid = false;
            }
        /* -------------------- END OF INSERTION --------------------*/

        return valid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();

        for(int i = 0; i < numCases; i++) 
        {

            int value = sc.nextInt();

            int checkbit = sc.nextInt();

            if (solveErrorDetection(value, checkbit)) {
                System.out.println("Valid");
            }
            else {
                System.out.println("Corrupt");
            }
        }
    }
}
