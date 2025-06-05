import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int min = 0;
        while (true) {
            min++;

            if (min * min >= N) {
                break;
            }
        }

        int bound = min;

        for (int i = 1; i <= (bound + 2); i++) {
            bw.write("x");
        }
        bw.write("\n");

        for (int i = 1; i <= bound; i++) {
            bw.write("x");
            for (int j = 1; j <= bound; j++) {
                bw.write(".");
            }
            bw.write("x\n");
        }

        for (int i = 1; i <= (bound + 2); i++) {
            bw.write("x");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
