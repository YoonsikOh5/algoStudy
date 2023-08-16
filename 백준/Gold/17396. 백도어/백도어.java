import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static int a, b;
    static long c;
    static List<Edge>[] lsArr;
    static boolean[] visited;
    static long cnt;

    static class Edge {
        int left;
        int right;
        long times;

        public Edge(int left, int right, long times) {
            this.left = left;
            this.right = right;
            this.times = times;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lsArr = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            lsArr[i] = new LinkedList<Edge>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                visited[i] =true;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

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

        Arrays.fill(minFromC, Integer.MAX_VALUE);

        minFromC[0] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {

                if(o1.times > o2.times){
                    return 1;
                } else if(o1.times < o2.times){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        pq.offer(new Edge(0, 0, 0));
        cnt = -1;
        while (pq.size() > 0) {

            Edge poll = pq.poll();

            long ptimes = poll.times;
            int pleft = poll.left;
            // 여기서 부터 다시 출발이니까 여기를 기준으로
            int pright = poll.right;

            if (visited[pright] == false) {
                visited[pright] = true;
                if (pright == N-1) {
                    cnt = ptimes;
                }
            } else {
                continue;
            }

            List<Edge> edges = lsArr[pright];

            for (Edge edge : edges) {
                if (visited[edge.right] == false) {
                    Edge nEdge = new Edge(poll.right, edge.right, ptimes + edge.times);
                    pq.offer(nEdge);
                }
            }

        }
    }
}