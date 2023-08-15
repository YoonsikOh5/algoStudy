import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static int a, b, c;
    static List<Edge>[] lsArr;
    static int cnt;

    static class Edge {
        int left;
        int right;
        int cows;

        public Edge(int left, int right, int cows) {
            this.left = left;
            this.right = right;
            this.cows = cows;
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
            lsArr[i] = new LinkedList<Edge>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            Edge edgea = new Edge(a, b, c);
            lsArr[a].add(edgea);
            Edge edgeb = new Edge(b, a, c);
            lsArr[b].add(edgeb);
        }


        dijk();

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijk() {
        int[] minFromC = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(minFromC, Integer.MAX_VALUE);

        minFromC[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cows - o2.cows;
            }
        });

        pq.offer(new Edge(1, 1, 0));
        cnt = 0;
        while (pq.size() > 0) {

            Edge poll = pq.poll();

            int pcows = poll.cows;
            int pleft = poll.left;
            // 여기서 부터 다시 출발이니까 여기를 기준으로
            int pright = poll.right;

            if (visited[pright] == false) {
                visited[pright] = true;
                if (pright == N) {
                    cnt = pcows;
                }
            } else {
                continue;
            }

            List<Edge> edges = lsArr[pright];

            for (Edge edge : edges) {
                if (visited[edge.right] == false) {
                    Edge nEdge = new Edge(poll.right, edge.right, pcows + edge.cows);
                    pq.offer(nEdge);
                }
            }

        }
    }
}