import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N + 1];
            int size = 0;
            for (int i = 0; i < N; i++) {
                int cur = arr[i];

                int index = Arrays.binarySearch(dp, 0, size, cur);

                if (index > 0) {
                    continue;
                }

                int inputIndex = Math.abs(index + 1);

                if (inputIndex == size) {
                    dp[inputIndex] = cur;
                    size++;
                } else {
                    dp[inputIndex] = cur;
                }
            }

            bw.write("Case #" + tc + "\n");
            if (size >= K) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}