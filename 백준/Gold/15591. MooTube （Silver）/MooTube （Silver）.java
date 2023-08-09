import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;

    static List<Edge>[] nodeArr;

    static class Edge {
        int start;
        int end;
        int USADO;

        public Edge(int start, int end, int USADO) {
            this.start = start;
            this.end = end;
            this.USADO = USADO;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        nodeArr = new LinkedList[N + 1];

        for (int i = 1; i <= N; i++) {
            nodeArr[i] = new LinkedList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            nodeArr[p].add(new Edge(p, q, r));
            nodeArr[q].add(new Edge(q, p, r));
        }

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int result = bfs(k, v);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int k, int v) {
        int result = 0;
        boolean[] visited = new boolean[N + 1];
        Queue<Edge> q = new LinkedList<>();
        List<Edge> edges = nodeArr[v];
        visited[v] = true;
        for (Edge edge : edges) {
            visited[edge.end] = true;
            q.offer(edge);
        }
        while (q.size() > 0) {
            Edge poll = q.poll();
            int cend = poll.end;
            int cusado = poll.USADO;
            if (cusado >= k) {
                result++;
            }
            List<Edge> edges1 = nodeArr[cend];
            for (Edge edge : edges1) {
                if (visited[edge.end] == false) {
                    visited[edge.end] = true;
                    q.offer(new Edge(cend, edge.end, Math.min(cusado, edge.USADO)));
                }
            }
        }

        return result;
    }


}