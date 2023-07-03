import java.io.*;
import java.util.*;

public class Main {

    static int INF = 1_000_000_001;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (r == c) continue;
                board[r][c] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
            board[b][a] = 1;
        }

        // 경 출 도
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k) continue;
                for (int j = 1; j <= N; j++) {
                    if (j == k) continue;

                    if (board[i][j] > board[i][k] + board[k][j]) {
                        board[i][j] = board[i][k] + board[k][j];
                    }

                }
            }
        }

        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        for (int idx = 1; idx <= N; idx++) {
            int[] ints = board[idx];
            int sum = 0;
            for (int i = 0; i < ints.length; i++) {
                sum += ints[i];
            }
            if (min > sum) {
                min = sum;
                minIdx = idx;
            }
        }
        
        bw.write(minIdx+"");
        bw.flush();
        bw.close();
        br.close();
    }


}