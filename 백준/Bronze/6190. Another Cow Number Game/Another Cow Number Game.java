import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine().trim());

        long score = 0;
        while (n != 1) {
            if ((n % 2) == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            score++;
        }

        bw.write(score+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
