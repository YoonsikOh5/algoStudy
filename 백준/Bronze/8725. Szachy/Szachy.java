import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        long answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowMax = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value > rowMax) {
                    rowMax = value;
                }
            }

            if (rowMax > 0) {
                answer += rowMax;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
