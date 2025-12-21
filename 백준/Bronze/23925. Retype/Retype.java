import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int a1 = N + 1;
            int a2 = (K - S) + (N - S + 1);

            int res = Math.min(a1, a2);
            res+=(K-1);
            bw.write("Case #"+i+": "+res+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
