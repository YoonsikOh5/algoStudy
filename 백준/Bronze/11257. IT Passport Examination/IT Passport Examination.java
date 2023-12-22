import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String id = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            boolean isPassed = true;

            int sum = a + b + c;

            if (sum < 55) {
                isPassed = false;
            }
            if (a < 35 * 0.3) {
                isPassed = false;
            }
            if (b < 25 * 0.3) {
                isPassed = false;
            }
            if (c < 40 * 0.3) {
                isPassed = false;
            }

            if (isPassed) {
                bw.write(id + " " + sum + " PASS\n");
            } else {
                bw.write(id + " " + sum + " FAIL\n");
            }

        }


        bw.flush();
        bw.close();
        br.close();
    }

}