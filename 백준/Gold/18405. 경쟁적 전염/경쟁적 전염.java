import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static PriorityQueue<Virus> pq;

    static int N;
    static int K;

    static int S;
    static int X;
    static int Y;

    static class Virus implements Comparable<Virus> {
        int num;
        int r;
        int c;

        public Virus(int num, int i, int j) {
            this.num = num;
            this.r = i;
            this.c = j;
        }

        @Override
        public int compareTo(Virus o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        pq = new PriorityQueue<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int cur = Integer.parseInt(st.nextToken());
                board[r][c] = cur;
                if (cur != 0) {
                    pq.offer(new Virus(cur, r, c));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        bfs(0);

        bw.write(board[X-1][Y-1]+"");
        bw.flush();
        bw.close();
        br.close();
    }

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static void bfs(int time) {

        while (time < S) {

            PriorityQueue<Virus> nextPq = new PriorityQueue<>();

            while (pq.size() > 0) {

                Virus poll = pq.poll();

                int num = poll.num;
                int r = poll.r;
                int c = poll.c;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        if (board[nr][nc] == 0) {
                            board[nr][nc] = num;
                            nextPq.offer(new Virus(num, nr, nc));
                        }
                    }
                }
            }

            time++;
            pq = nextPq;
        }

    }

}