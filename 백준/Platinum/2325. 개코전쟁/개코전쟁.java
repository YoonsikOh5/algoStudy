import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Edge>[] lsArr;
    static Edge minRouteEdge;
    static int resultMax;

    static class Edge {
        int start;
        int end;
        int dist;
        List<Integer> ls;

        public Edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
            ls = new LinkedList<>();
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lsArr = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            lsArr[i] = new LinkedList<>();
        }
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            lsArr[x].add(new Edge(x, y, z));
            lsArr[y].add(new Edge(y, x, z));
        }
        doDijk();
        List<Integer> minRouteList = minRouteEdge.ls;
        int cur = 1;
        int next = 0;
        resultMax = 0;
        for (Integer cNum : minRouteList) {
            next = cNum;
            doDijk(cur, next);
            cur = cNum;
        }


        bw.write(resultMax + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void doDijk(int cur, int next) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });
        pq.offer(new Edge(1, 1, 0));
        while (pq.size() > 0) {
            Edge poll = pq.poll();
            int befEnd = poll.end;
            int befDist = poll.dist;
            if (visited[befEnd]) {
                continue;
            }
            if (befEnd == N) {
                resultMax = Math.max(resultMax, befDist);
                break;
            }
            visited[befEnd] = true;
            List<Edge> edges = lsArr[befEnd];
            for (Edge edge : edges) {
                int nextEnd = edge.end;
                if ((befEnd == cur && nextEnd == next) ||(befEnd == next && nextEnd == cur) ) continue;
                if (visited[nextEnd]) continue;
                int cdist = edge.dist;
                int ndist = befDist + cdist;
                Edge nedge = new Edge(befEnd, nextEnd, ndist);
                pq.offer(nedge);
            }
        }
    }

    private static void doDijk() {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });
        pq.offer(new Edge(1, 1, 0));
        while (pq.size() > 0) {
            Edge poll = pq.poll();
            int befEnd = poll.end;
            int befDist = poll.dist;
            List<Integer> ls = poll.ls;
            if (visited[befEnd]) {
                continue;
            }
            if (befEnd == N) {
                minRouteEdge = poll;
                break;
            }
            visited[befEnd] = true;
            List<Edge> edges = lsArr[befEnd];
            for (Edge edge : edges) {
                int nextEnd = edge.end;
                if (visited[nextEnd]) continue;
                int cdist = edge.dist;
                int ndist = befDist + cdist;
                Edge nedge = new Edge(befEnd, nextEnd, ndist);
                for (Integer l : ls) {
                    nedge.ls.add(l);
                }
                nedge.ls.add(nextEnd);
                pq.offer(nedge);
            }
        }
    }

}