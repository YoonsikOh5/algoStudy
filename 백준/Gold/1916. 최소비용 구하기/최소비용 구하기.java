import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int sc, ec;
    static List<Edge>[] ls;

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ls = new List[N+1];
        for(int i = 0; i <= N; i++){
            ls[i] = new LinkedList<Edge>();
        }

        for(int i = 1; i <= M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(start, end, cost);
            ls[start].add(edge);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        sc = Integer.parseInt(st.nextToken());
        ec = Integer.parseInt(st.nextToken());

        int result = dijk();

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijk() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(sc,sc,0));
        boolean[] visited = new boolean[N+1];
        while (pq.size()>0){
            Edge poll = pq.poll();

            int start = poll.start;
            int end = poll.end;
            int cost = poll.cost;

            if(visited[end]==true){
                continue;
            }
            visited[end] = true;
            if(end == ec){
                return cost;
            }

            List<Edge> l = ls[end];
            for (Edge edge : l) {
                if(visited[edge.end]==false){
                    pq.offer(new Edge(end, edge.end, cost+edge.cost));
                }
            }
        }
        return -1;
    }
}