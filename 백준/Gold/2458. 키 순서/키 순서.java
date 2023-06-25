import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                dp[i][j] = 1;
            }
        }

        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp[a][b] = 0;
        }

        // 경 출 도
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = 1; j <= N; j++) {
                    if (j == k) {
                        continue;
                    }
                    if (dp[i][k] == 0 && dp[k][j] == 0) {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            boolean isAble = true;
            for (int j = 1; j <= N; j++) {
                if (dp[i][j] == 1) {
                    if (dp[j][i] == 1) {
                        isAble = false;
                        break;
                    }
                }
            }
            if(isAble){
                result++;
            }
        }


        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }


}