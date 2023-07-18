import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;
    static int[][] slopeBoard;

    static class Road implements Comparable<Road> {
        int r;
        int c;
        int slope;

        public Road(int r, int c, int slope) {
            this.r = r;
            this.c = c;
            this.slope = slope;
        }


        @Override
        public int compareTo(Road o) {
            return this.slope - o.slope;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        slopeBoard = new int[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                slopeBoard[r][c] = Integer.MAX_VALUE;
            }
        }

        int result = dijk();

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static int dijk() {
        int resultMax = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>();
        slopeBoard[0][0] = 0;
        pq.offer(new Road(0, 0, 0));

        while (pq.size() > 0) {
            Road poll = pq.poll();
            int pslope = poll.slope;
            int pr = poll.r;
            int pc = poll.c;
//            System.out.println(poll.r+" "+ poll.c+" "+pslope+"\n");
            if (slopeBoard[pr][pc] < pslope) {
                continue;
            }
            slopeBoard[pr][pc] = pslope;
            resultMax = Math.max(resultMax,pslope);
            if (pr == N - 1 && pc == N - 1) {
                return resultMax;
            }
            for (int d = 0; d < 4; d++) {
                int nr = pr + dr[d];
                int nc = pc + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    int nslope = Math.abs(board[nr][nc] - board[pr][pc]);
                    if (slopeBoard[nr][nc] == Integer.MAX_VALUE) {
                        pq.offer(new Road(nr, nc, nslope));
                    }
                }
            }
        }
        return resultMax;
    }
}