import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long sum = 1;

        for (int i = 1; i <= N; i++) {
            sum *= i;
        }

        sum /= (7 * 24 * 60 * 60);
        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }


}