import java.io.*;
import java.util.*;

public class Main {

    static int INF = 1_000_000_001;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                board[r][c] = INF;
            }
        }

        for (int r = 1; r <= N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    board[r][c] = a;
                }
            }
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

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (board[r][c] != INF) {
                    bw.write("1 ");
                } else {
                    bw.write("0 ");
                }
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }


}