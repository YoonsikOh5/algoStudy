import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] repArr;
    static HashSet<Integer> hs;
    static PriorityQueue<Edge> pq;

    PriorityQueue<Edge> edgeList;

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // 가중치 기준 오름차순
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        hs = new HashSet<>();
        pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            hs.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(u, v, w));
        }

        repArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            repArr[i] = i;
        }

        int cnt = 0;
        long costSum = 0;
        while (pq.size() > 0) {
            Edge cur = pq.poll();
            if (merge(cur.from, cur.to)) {
                cnt++;
                costSum += cur.weight;
                if (cnt == N - K) {
                    break;
                }
            }
        }

        bw.write(costSum + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean merge(int left, int right) {
        int leftrep = findrep(left);
        int rightrep = findrep(right);
        if (hs.contains(leftrep) && hs.contains(rightrep)) {
            return false;
        }
        if (leftrep == rightrep) {
            return false;
        }
        if (hs.contains(leftrep)) {
            repArr[rightrep] = leftrep;
            return true;
        }
        if(hs.contains(rightrep)){
            repArr[leftrep] = rightrep;
            return true;
        }
        repArr[rightrep] = leftrep;
        return true;
    }

    static int findrep(int i) {
        if (hs.contains(repArr[i])) {
            return repArr[i];
        }
        if (repArr[i] == i) {
            return i;
        }
        return repArr[i] = findrep(repArr[i]);
    }

}