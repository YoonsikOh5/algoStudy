import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int cur = 0;
            for (int j = 1; j <= 3; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                cur += a * A;
                int b = Integer.parseInt(st.nextToken());
                cur += b * B;
                int c = Integer.parseInt(st.nextToken());
                cur += c * C;
            }
            max = Math.max(max, cur);
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
