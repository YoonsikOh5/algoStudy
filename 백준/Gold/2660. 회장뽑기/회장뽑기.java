import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());


        dp = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                dp[i][j] = 100;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while (!(a == -1 && b == -1)) {

            dp[a][b] = 1;
            dp[b][a] = 1;

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
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
                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

//        for (int[] ints : dp) {
//            bw.write(Arrays.toString(ints)+"\n");
//        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int curMin = 300;
        for(int i = 1; i <= N; i++){
            int minNum = 1;
            for(int j = 1; j <= N; j++){
                if(minNum < dp[i][j]){
                    minNum = dp[i][j];
                }
            }
            if(curMin > minNum){
                curMin = minNum;
                pq = new PriorityQueue<>();
                pq.offer(i);
            } else if(curMin == minNum){
                pq.offer(i);
            }
        }


        bw.write(curMin+" "+pq.size()+"\n");
        while (pq.size()>0){
            bw.write(pq.poll()+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}