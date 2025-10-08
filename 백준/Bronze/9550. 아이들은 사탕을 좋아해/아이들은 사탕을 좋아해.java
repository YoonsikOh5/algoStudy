import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int res = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                int div = cur / K;
                res += div;
            }
            bw.write(res + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
