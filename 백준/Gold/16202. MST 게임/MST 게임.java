import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] reps;
    static Edge[] edges;
    static boolean findMST;

    static PriorityQueue<Edge> pq;
    static int resultWeight;

    static class Edge implements Comparable<Edge> {
        int left;
        int right;

        int weight;

        public Edge(int left, int right, int weight) {
            this.left = left;
            this.right = right;
            this.weight = weight;
        }

        // 무게 오름차순
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        pq = new PriorityQueue<>();

        reps = new int[N + 1];

        edges = new Edge[M + 1];


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(h1, h2, i);
        }


        findMST = true;
        for (int i = 1; i <= K; i++) {
            if (findMST) {
                resultWeight = 0;
                init();
                doDijk(i);
                if (findMST) {
                    bw.write(resultWeight + " ");
                } else {
                    bw.write("0 ");
                }
            } else {
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void init() {
        for (int i = 1; i <= N; i++) {
            reps[i] = i;
        }
    }

    private static void doDijk(int start) {

        int picked = 0;
        findMST = false;
        for (int i = start; i <= M; i++) {

            Edge poll = edges[i];
            int left = poll.left;
            int right = poll.right;
            int weight = poll.weight;
            if (merge(left, right)) {
                picked++;
                resultWeight += weight;
                if (picked == N - 1) {
                    break;
                }
            }
        }

        if (picked == N - 1) {
            findMST = true;
        }

    }

    private static boolean merge(int left, int right) {
        int leftrep = findrep(left);
        int rightrep = findrep(right);
        if (leftrep == rightrep) {
            return false;
        }
        reps[rightrep] = leftrep;
        return true;
    }

    private static int findrep(int i) {
        if (reps[i] == i) {
            return i;
        }
        return reps[i] = findrep(reps[i]);
    }

}