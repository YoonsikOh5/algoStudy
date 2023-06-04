import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;

    // 도로의 포장수 visited
    static boolean[][] visited;
    static List<Edge>[] els;

    static class Edge implements Comparable<Edge> {
        boolean wrapped;
        int wrappedCount;
        int left;
        int right;
        long len;

        public Edge(boolean wrapped, int left, int right, long len) {
            this.wrapped = wrapped;
            this.left = left;
            this.right = right;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            Long cp = this.len - o.len;
            return cp.intValue();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        els = new List[N + 1];

        visited = new boolean[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            els[i] = new LinkedList<Edge>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            long len = Long.parseLong(st.nextToken());
            els[left].add(new Edge(false, left, right, len));
            els[right].add(new Edge(false, right, left, len));
            els[left].add(new Edge(true, left, right, 0));
            els[right].add(new Edge(true, right, left, 0));
        }

        long result = dijk();

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long dijk() {

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(false, 1, 1, 0));

        // 0은 일부러 안 함
        for (int i = 1; i <= K; i++) {
            visited[1][i] = true;
        }

        while (pq.size() > 0) {
            Edge poll = pq.poll();

            int wrappedCount = poll.wrappedCount;
            int left = poll.left;
            int right = poll.right;
            long len = poll.len;

            if (visited[right][wrappedCount] == true) {
                continue;
            }
            visited[right][wrappedCount] = true;
            if (right == N) {
                return len;
            }

            List<Edge> el = els[right];
            for (Edge edge : el) {
                if (edge.wrapped == true) {
                    // 아직 포장 가능하면 포장
                    if (wrappedCount < K) {
                        Edge wEdge = new Edge(true, edge.left, edge.right, len + edge.len);
                        wEdge.wrappedCount = wrappedCount + 1;
                        pq.offer(wEdge);
                    }
                } else {
                    Edge wEdge = new Edge(false, edge.left, edge.right, len + edge.len);
                    wEdge.wrappedCount = wrappedCount;
                    pq.offer(wEdge);
                }
            }

        }

        return 0;
    }
}