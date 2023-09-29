import java.io.*;
import java.util.*;

public class Main {

    static int N;
    // 현재 최솟값 담을 곳들
    static int[] arr;
    static boolean[] visited;
    static int[][] board;
    static int resultSum;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        arr = new int[N];
        board = new int[N][N];
        int min = Integer.MAX_VALUE;
        int minNum = -1;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            arr[i] = cur;
            board[i][i] = cur;
            if (min > arr[i]) {
                min = arr[i];
                minNum = i;
            }
        }
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                if (r == c) {
                    st.nextToken();
                    continue;
                }
                int cur = Integer.parseInt(st.nextToken());
                board[r][c] = cur;
            }
        }

        krus(minNum);
        bw.write(resultSum + "");
        bw.flush();
        bw.close();
        br.close();

    }

    // 시작은 물대는게 가장 작은 친구
    private static void krus(int minNum) {
        visited[minNum] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(minNum);
        while (q.size() > 0) {
            Integer pollR = q.poll();
            visited[pollR] = true;
            resultSum += arr[pollR];
            int[] row = board[pollR];
            int min = Integer.MAX_VALUE;
            int minIdx = -1;

            for (int c = 0; c < N; c++) {
                int cur = row[c];
                if (visited[c] == false) {
                    arr[c] = Math.min(arr[c], cur);
                    if (min > arr[c]) {
                        min = arr[c];
                        minIdx = c;
                    }
                }
            }
            if(minIdx == -1){
                continue;
            }
            q.offer(minIdx);

        }
    }
}