import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            int total = 0;

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            for (int start = 0; start < N; start++) {
                int[] dp = new int[N + 1];
                int size = 0;
                for (int i = start; i < N; i++) {
                    int cur = arr[i];

                    int index = Arrays.binarySearch(dp, 0, size, cur);

                    if (index >= 0) {
                        total += size;
                        continue;
                    }

                    int inputIndex = Math.abs(index + 1);

                    if (inputIndex == size) {
                        dp[inputIndex] = cur;
                        size++;
                        total += size;
                    } else {
                        dp[inputIndex] = cur;
                        total += size;
                    }
                }
            }
            bw.write("Case #" + tc + ": " + total + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}