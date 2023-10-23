import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // dp[i][j][p] i번째 주문에서 치즈버거가 j개 햄버거가 p개 남아 있을때의 최대 주문량
        int[][][] dp = new int[N + 1][M + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= M; j++) {
                if (j >= x) {
                    for (int p = 0; p <= K; p++) {
                        if (p >= y) {
                            dp[i][j][p] = Math.max(dp[i-1][j][p], 1+dp[i-1][j-x][p-y]);
                        } else {
                            dp[i][j][p] = dp[i-1][j][p];
                        }
                    }
                } else {
                    for(int p = 0; p <= K; p++){
                        dp[i][j][p] = dp[i-1][j][p];
                    }
                }
            }
        }

        bw.write(dp[N][M][K] + "");
        bw.flush();
        bw.close();
        br.close();
    }


}