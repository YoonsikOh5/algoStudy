import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int res = 1;
        while (x >= 0) {
            if (res == 1) {
                x -= k;
                if (x < 0) {
                    bw.write(res + "");
                }
                res = 0;
            } else if (res == 0) {
                x -= a;
                if (x < 0) {
                    bw.write(res + "");
                }
                res = 1;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
