import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        int size = 0;

        for (int i = 0; i < n; i++) {
            int cur = arr[i];
    
            // 이 index는 dp 안에 cur이 있으면 그 index(양수)를 반환
            // cur이 없으면 cur이 들어갈 index(들어갈 곳 + 1의 음수)를 반환
            int index = Arrays.binarySearch(dp, 0, size, cur);

            if (index > 0) {
                continue;
            }

            int inputIndex = Math.abs(index + 1);

            dp[inputIndex] = cur;

            if (inputIndex == size) {
                size++;
            }

        }

        bw.write((n-size)+"");
        bw.flush();
        bw.close();
        br.close();
    }

}