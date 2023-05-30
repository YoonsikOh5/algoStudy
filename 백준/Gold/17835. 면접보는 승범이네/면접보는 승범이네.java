import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static List<EdgeL>[] ls;

    static long[] arr;
    static List<Integer> startList;

    static class EdgeL implements Comparable<EdgeL> {

        int start;
        int end;
        long len;

        public EdgeL(int start, int end, long len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(EdgeL o) {
            Long llen = this.len - o.len;
            return llen.intValue();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ls = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            ls[i] = new LinkedList<>();
        }
        arr = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = Long.MAX_VALUE;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
//            ls[u].add(new EdgeL(u, v, c));
            ls[v].add(new EdgeL(v, u, c));
        }

        startList = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            startList.add(Integer.parseInt(st.nextToken()));
        }

        doDijk();

        long maxi = 0;
        long maxl = 0;
        for (int i = 1; i <= N; i++) {
            if (maxl < arr[i]) {
                maxl = arr[i];
                maxi = i;
            }
        }

        bw.write(maxi + "\n" + maxl);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void doDijk() {

        boolean[] visited = new boolean[N + 1];

        PriorityQueue<EdgeL> pq = new PriorityQueue<>();

        for (Integer integer : startList) {
            pq.offer(new EdgeL(integer, integer, 0));
            arr[integer] = 0;
        }

        while (pq.size() > 0) {
            EdgeL poll = pq.poll();
            int start = poll.start;
            int end = poll.end;
            long len = poll.len;

            if (visited[end] == true) {
                continue;
            }
            visited[end] = true;
            arr[end] = len;

            for (EdgeL cur : ls[end]) {
                if (visited[cur.end] == false) {
                    pq.offer(new EdgeL(end, cur.end, len + cur.len));
                }
            }

        }

    }
}