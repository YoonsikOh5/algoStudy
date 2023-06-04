import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;

    // dp
    static int[][] dp;
    static boolean[][] visited;
    static List<Edge>[] els;

    static class Edge implements Comparable<Edge> {
        int curCost;
        int left;
        int right;
        int price;
        int len;

        public Edge(int left, int right, int price, int len) {
            this.left = left;
            this.right = right;
            this.price = price;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.len == o.len) {
                return this.curCost - o.curCost;
            }
            return this.len - o.len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            els = new List[N + 1];

            dp = new int[N + 1][M + 1];
            visited = new boolean[N + 1][M + 1];

            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= M; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i <= N; i++) {
                els[i] = new LinkedList<Edge>();
            }

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());
                els[left].add(new Edge(left, right, price, len));
            }
            int result = dijk();
            if (result != -1) {
                bw.write(result + "\n");
            } else if (result == -1) {
                bw.write("Poor KCM\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijk() {

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(1, 1, 0, 0));

        for (int i = 0; i <= M; i++) {
            dp[1][i] = 0;
        }

        for (int i = 1; i <= M; i++) {
            visited[1][i] = true;
        }

        while (pq.size() > 0) {
            Edge poll = pq.poll();

            int cost = poll.curCost;
            int left = poll.left;
            int right = poll.right;
            int len = poll.len;

            if (visited[right][cost] == true) {
                continue;
            }
            visited[right][cost] = true;
            if (right == N) {
                return len;
            }

            List<Edge> el = els[right];
            for (Edge edge : el) {
                if (cost + edge.price <= M && dp[edge.right][cost + edge.price] > len + edge.len) {
                    dp[edge.right][cost + edge.price] = len + edge.len;
                    Edge wEdge = new Edge(edge.left, edge.right, 0, len + edge.len);
                    wEdge.curCost = cost + edge.price;
                    pq.offer(wEdge);
                }
            }
        }
        return -1;
    }
}