import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    // dp[i][j] i원을 들고 j를 갈때의 최소거리
    static int[][] dp;
    static List<Edge>[] edgeLs;

    static class Edge {
        int start;
        int end;
        int cost;
        int dist;

        public Edge(int start, int end, int cost, int dist) {
            this.start = start;
            this.end = end;
            this.cost = cost;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", cost=" + cost +
                    ", dist=" + dist +
                    '}';
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());


        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            edgeLs = new List[N + 1];
            for (int n = 1; n <= N; n++) {
                edgeLs[n] = new LinkedList<>();
            }

            for (int k = 1; k <= K; k++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                edgeLs[u].add(new Edge(u, v, c, d));
            }

            for(int n = 1; n <= N; n++){
                edgeLs[n].sort(new Comparator<Edge>() {
                    @Override
                    public int compare(Edge o1, Edge o2) {
                        return o1.dist - o2.dist;
                    }
                });
            }



            dijk();
            int minResult = Integer.MAX_VALUE;
            for (int m = 0; m <= M; m++) {
                minResult = Math.min(minResult, dp[m][N]);
            }
            if (minResult == Integer.MAX_VALUE) {
                bw.write("Poor KCM\n");
            } else {
                bw.write(minResult + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijk() {
        dp = new int[M + 1][N + 1];

        for (int m = 0; m <= M; m++) {
            for (int n = 2; n <= N; n++) {
                dp[m][n] = Integer.MAX_VALUE;
            }
        }

        Queue<Edge> q = new LinkedList<>();

        q.offer(new Edge(1, 1, 0, 0));

        while (q.size() > 0) {
            Edge poll = q.poll();
            int pe = poll.end;
            int pd = poll.dist;
            int pc = poll.cost;
            if (pe == N) continue;
            if (pd > dp[pc][pe]) {
                continue;
            }
            List<Edge> edgeL = edgeLs[pe];
            outLoop:
            for (Edge edge : edgeL) {
                int ee = edge.end;
                int ed = edge.dist;
                int ec = edge.cost;
                int cc = pc + ec;
                if (cc > M) {
                    continue;
                }
                int cd = pd + ed;

                if (cd >= dp[cc][ee]) {
                    continue;
                }

                for (int m = cc+1; m <= M; m++) {
                    if (dp[m][ee] > cd) {
                        dp[m][ee] = cd;
                    } else if (dp[m][ee] <= cd) {
                        break;
                    }
                }
                dp[cc][ee] = cd;
                q.offer(new Edge(pe, ee, cc, cd));

            }
        }
    }
}