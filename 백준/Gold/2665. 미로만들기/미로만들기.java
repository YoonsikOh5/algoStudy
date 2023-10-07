import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int[][] visitMin;
    static int result;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                board[r][c] = str.charAt(c) - '0';
            }
        }
        visitMin = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                visitMin[r][c] = Integer.MAX_VALUE;
            }
        }
        dijk();

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static class RCD implements Comparable<RCD> {
        int r;
        int c;
        int d;

        public RCD(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(RCD o) {
            return this.d - o.d;
        }
    }

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static void dijk() {
        PriorityQueue<RCD> pq = new PriorityQueue<>();
        pq.offer(new RCD(0, 0, 0));

        while (pq.size() > 0) {
            RCD poll = pq.poll();
            int pr = poll.r;
            int pc = poll.c;
            int pd = poll.d;
            if (visitMin[pr][pc] <= pd) {
                continue;
            }
            visitMin[pr][pc] = pd;
            for (int d = 0; d < 4; d++) {
                int nr = pr + dr[d];
                int nc = pc + dc[d];

                if (inRange(nr, nc)) {
                    if (nr == N - 1 && nc == N - 1) {
                        result = pd;
                        return;
                    }
                    if (board[nr][nc] == 1) {
                        if (visitMin[nr][nc] > pd) {
                            pq.offer(new RCD(nr, nc, pd));
                        }
                    } else if (board[nr][nc] == 0) {
                        if (visitMin[nr][nc] > (pd + 1)) {
                            pq.offer(new RCD(nr, nc, pd + 1));
                        }
                    }

                }

            }
        }
    }

    private static boolean inRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            return true;
        } else {
            return false;
        }
    }

}