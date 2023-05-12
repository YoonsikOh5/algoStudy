import java.io.*;
import java.util.*;

public class Main {

    static int n, m, r;
    static int[] itemArr;
    static List<Edge>[] ls;

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int len;

        public Edge(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return this.len - o.len;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        itemArr = new int[n + 1];
        ls = new List[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemArr[i] = Integer.parseInt(st.nextToken());
            ls[i] = new LinkedList<>();
        }

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            ls[a].add(new Edge(a, b, l));
            ls[b].add(new Edge(b, a, l));
        }

        int maxResult = 0;
        for (int i = 1; i <= n; i++) {
            int result = dijk(i);
            maxResult = Math.max(result, maxResult);
        }

        bw.write(maxResult + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijk(int start) {

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue();
        pq.add(new Edge(start, start, 0));
        int sum = 0;

        while (pq.size() > 0) {
            Edge poll = pq.poll();
            int pstart = poll.start;
            int pend = poll.end;
            int plen = poll.len;

            if (visited[pend] == true) {
                continue;
            }
            if (plen > m) {
                break;
            }
            visited[pend] = true;
            sum += itemArr[pend];

            List<Edge> l = ls[pend];
            for (Edge edge : l) {
                pq.add(new Edge(edge.start, edge.end, plen + edge.len));
            }

        }
        return sum;
    }

}
