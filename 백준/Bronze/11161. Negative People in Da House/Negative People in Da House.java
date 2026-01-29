import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int M = Integer.parseInt(br.readLine());
            int max = 0;
            int cur = 0;
            for (int j = 1; j <= M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int in = Integer.parseInt(st.nextToken());
                int out = Integer.parseInt(st.nextToken());
                int omi = out - in;
                cur += omi;
                max = Math.max(max, cur);
            }
            bw.write(max+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
