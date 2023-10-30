import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] stocks = new int[C + 1][D + 1];


        for (int i = 1; i <= C; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= D; j++) {
                stocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int d = 1; d < D; d++) {
            int[] dp = new int[500001];
            for (int c = 1; c <= C; c++) {
                int[] stock = stocks[c];
                int todayPrice = stock[d];
                int tomorrowPrice = stock[d + 1];
                for (int m = todayPrice; m <= M; m++) {
                    dp[m] = Math.max(dp[m], dp[m - todayPrice] + (tomorrowPrice - todayPrice));
                }
            }
            int yesterdayProfit = dp[M];
            M += yesterdayProfit;
        }
        bw.write(M + "");
        bw.flush();
        bw.close();
        br.close();

    }


}