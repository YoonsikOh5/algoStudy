import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memories = new int[N + 1];
        int[] costs = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int costSum = 0;
        for (int i = 1; i <= N; i++) {
            int cost = Integer.parseInt(st.nextToken());
            costs[i] = cost;
            costSum += cost;
        }

        // cost
        int[][] dp = new int[N + 1][costSum + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= costSum; j++) {
                if (j >= costs[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], memories[i] + dp[i - 1][j - costs[i]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int minIdx = 0;
        for(int i = 0; i <= costSum; i++){
            int cur = dp[N][i];
            if(cur >= M){
                minIdx = i;
                break;
            }
        }
        bw.write(minIdx+"");
        bw.flush();
        bw.close();
        br.close();

    }

}