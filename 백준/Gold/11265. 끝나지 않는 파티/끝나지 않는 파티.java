import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N+1][N+1];
        for(int r = 1; r <= N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= N; c++){
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                if(i==k){
                    continue;
                }
                for(int j = 1; j <= N; j++){
                    if(j==k){
                        continue;
                    }
                    if(board[i][j] > board[i][k]+board[k][j]){
                        board[i][j] = board[i][k] + board[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(board[a][b] <= c){
                bw.write("Enjoy other party\n");
            } else {
                bw.write("Stay here\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }


}