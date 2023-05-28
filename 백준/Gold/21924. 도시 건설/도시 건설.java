import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static long total, selTotal;

    static PriorityQueue<Edge> pq;

    static int[] repArr;

    static class Edge implements Comparable<Edge> {
        int left;
        int right;
        int length;

        public Edge(int left, int right, int length) {
            this.left = left;
            this.right = right;
            this.length = length;
        }

        @Override
        public int compareTo(Edge o) {
            return this.length - o.length;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        total = 0;
        selTotal = 0;
        repArr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            repArr[i] = i;
        }

        pq = new PriorityQueue<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            total += c;
            pq.offer(new Edge(a, b, c));
        }

        if (doKruskal()) {
            bw.write((total - selTotal) + "");
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean doKruskal() {

        int selectedCnt = 0;

        while (pq.size() > 0) {
            Edge poll = pq.poll();

            int pl = poll.left;
            int pr = poll.right;

            if (merged(pl, pr)) {
                selTotal += poll.length;
                selectedCnt++;
                if (selectedCnt == N - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean merged(int pl, int pr) {
        if (findParent(pl) == findParent(pr)) {
            return false;
        } else {
            repArr[findParent(pl)] = findParent(pr);
            return true;
        }
    }

    private static int findParent(int child) {
        if (repArr[child] == child) {
            return child;
        } else {
            return repArr[child] = findParent(repArr[child]);
        }
    }
}
