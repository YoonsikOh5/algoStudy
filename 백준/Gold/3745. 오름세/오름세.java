import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "";
        while ((s = br.readLine()) != null) {
            s = s.trim();
            if (s == "" || s.length() == 0) {
                break;
            }
            int N = Integer.parseInt(s);

            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N + 1];
            int size = 0;
            for (int i = 0; i < N; i++) {
                int cur = arr[i];

                int index = Arrays.binarySearch(dp, 0, size, cur);

                if (index >= 0) {
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

            bw.write(size + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}