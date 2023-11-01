import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int S, D;
    static int[] taxArr;
    static List<Edge>[] edgeLs;
    // board[i][j] i번 이동해서 j를 갔을때의 최솟값
    static int[][] board;

    static class Edge {
        int from;
        int to;
        int dist;
        // 거쳐온 도시 수
        int num;

        public Edge(int from, int to, int dist, int num) {
            this.from = from;
            this.to = to;
            this.dist = dist;
            this.num = num;
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        edgeLs = new List[N + 1];
        taxArr = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            edgeLs[i] = new LinkedList<Edge>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeLs[a].add(new Edge(a, b, w, 0));
            edgeLs[b].add(new Edge(b, a, w, 0));
        }

        for (int i = 1; i <= K; i++) {
            taxArr[i] = Integer.parseInt(br.readLine());
        }

        board = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.MAX_VALUE;
            }
        }

        dijk();

        int curTax = 0;
        for (int k = 0; k <= K; k++) {
            long resultMin = Long.MAX_VALUE;
            curTax += taxArr[k];
            for (int i = 0; i < N; i++) {
                if(board[i][D]==Integer.MAX_VALUE) continue;
                resultMin = Math.min(resultMin, board[i][D] + (curTax * i));
            }
            bw.write(resultMin+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static void dijk() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.dist == o2.dist) {
                    return o1.dist - o2.dist;
                }
                return o1.dist - o2.dist;
            }
        });
        List<Edge> startEdges = edgeLs[S];
        board[0][S] = 0;
        board[1][S] = 0;
        for (Edge startEdge : startEdges) {
            int to = startEdge.to;
            int dist = startEdge.dist;
            board[1][to] = Math.min(board[1][to], dist);
            pq.offer(new Edge(S, to, dist, 1));
        }

        while (pq.size() > 0) {
            Edge poll = pq.poll();
            int pTo = poll.to;
            int pDist = poll.dist;
            int pNum = poll.num;

            List<Edge> curEdges = edgeLs[pTo];
            for (Edge curEdge : curEdges) {
                int cFrom = curEdge.from;
                int cTo = curEdge.to;
                int cDist = curEdge.dist;
                int pNump1 = pNum + 1;
                int pcDist = pDist + cDist;
                boolean isShorter = true;
                for (int i = 1; i <= pNump1; i++) {
                    if (board[i][cTo] < pcDist) {
                        isShorter = false;
                        break;
                    }
                }
                if (isShorter) {
                    board[pNump1][cTo] = pcDist;
                    pq.offer(new Edge(cFrom, cTo, pcDist, pNump1));
                }
            }
        }
    }
}