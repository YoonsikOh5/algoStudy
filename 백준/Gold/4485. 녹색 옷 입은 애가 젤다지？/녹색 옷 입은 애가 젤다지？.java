import java.io.*;
import java.util.*;


public class Main {
    static int N;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int minresult;

    static class RC {
        int r;
        int c;
        int dist;

        public RC(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int T = 1;
        while (N != 0) {

            int[][] cave = new int[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    cave[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] minDist = new int[N][N];
            for (int[] ints : minDist) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }

            boolean[][] visited = new boolean[N][N];

            minDist[0][0] = cave[0][0];
            visited[0][0] = true;

            RC start = new RC(0, 0, minDist[0][0]);

            PriorityQueue<RC> pq = new PriorityQueue<>(new Comparator<RC>() {
                @Override
                public int compare(RC o1, RC o2) {
                    return o1.dist - o2.dist;
                }
            });
            pq.offer(start);

            while (pq.size() > 0) {
                RC cur = pq.poll();

                int curr = cur.r;
                int curc = cur.c;


                if (curr == N - 1 && curc == N - 1) {
                    minresult = minDist[curr][curc];
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = curr + dr[d];
                    int nc = curc + dc[d];

                    if (inRange(nr, nc) && !visited[nr][nc]) {
                        minDist[nr][nc] = Math.min(minDist[nr][nc], minDist[curr][curc] + cave[nr][nc]);

                        visited[nr][nc] = true;
                        pq.offer(new RC(nr, nc, minDist[nr][nc]));
                    }
                }

            }

            bw.write("Problem " + T + ": " + minresult + "\n");
            T++;
            N = Integer.parseInt(br.readLine());
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static boolean inRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            return true;
        } else {
            return false;
        }
    }
}
