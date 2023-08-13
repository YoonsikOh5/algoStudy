import java.io.*;
import java.util.*;

public class Main {

    static int T;

    static int n, d, c;
    static List<Edge>[] lsArr;
    static int cnt;
    static int resultMax;

    static class Edge {
        int reliance;
        int host;
        int time;

        public Edge(int reliance, int host, int time) {
            this.reliance = reliance;
            this.host = host;
            this.time = time;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            lsArr = new List[n + 1];

            for (int i = 1; i <= n; i++) {
                lsArr[i] = new LinkedList<Edge>();
            }

            for (int i = 1; i <= d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                Edge edge = new Edge(a, b, s);
                lsArr[b].add(edge);
            }

            dijk();

            bw.write(cnt+" "+resultMax+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijk() {
        int[] minFromC = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(minFromC, Integer.MAX_VALUE);

        minFromC[n] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.time - o2.time;
            }
        });

        pq.offer(new Edge(c, c, 0));
        cnt = 0;
        resultMax = 0;
        while (pq.size() > 0) {

            Edge poll = pq.poll();

            int ptime = poll.time;
            int phost = poll.host;
            // 여기서 부터 다시 출발이니까 여기를 기준으로
            int preliance = poll.reliance;

            if (visited[preliance] == false) {
                visited[preliance] = true;
                resultMax = Math.max(resultMax, ptime);
                cnt++;
            } else {
                continue;
            }

            List<Edge> edges = lsArr[preliance];

            for (Edge edge : edges) {
                if (visited[edge.reliance] == false) {
                    Edge nEdge = new Edge(edge.reliance, edge.host, ptime + edge.time);
                    pq.offer(nEdge);
                }
            }

        }

    }


}