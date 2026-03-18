import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            int n = Integer.parseInt(line.trim());
            if (n == 0) {
                break;
            }

            int[] v = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int i = 1; i < n - 1; i++) {
                if (v[i] > v[i - 1] && v[i] > v[i + 1]) {
                    count++;
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
