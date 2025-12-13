import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cur = Integer.parseInt(br.readLine());

        while (cur != -1) {
            int res = 0;

            int ct = 0;
            for (int i = 0; i < cur; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int sp = Integer.parseInt(st.nextToken());
                int ti = Integer.parseInt(st.nextToken());
                res += sp * (ti - ct);
                ct = ti;
            }

            bw.write(res + " miles\n");
            cur = Integer.parseInt(br.readLine());
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
