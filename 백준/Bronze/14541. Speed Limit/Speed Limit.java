import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        while (N != -1) {
            int cur = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                cnt += a * (b - cur);
                cur = b;
            }
            bw.write(cnt + " miles\n");
            N = Integer.parseInt(br.readLine().trim());
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
