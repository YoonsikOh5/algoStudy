import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int T = 0;
        int B = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            T = Math.max(T,a);
            B = Math.min(B,b);
        }

        int tb = T * B;

        int res = (tb % 7) + 1;

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
