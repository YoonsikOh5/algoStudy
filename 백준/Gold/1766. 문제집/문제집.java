import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static PriorityQueue<Integer>[] ls;
    static int[] frontCnt;

    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ls = new PriorityQueue[N + 1];
        frontCnt = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            ls[i] = new PriorityQueue<Integer>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            ls[front].offer(back);
            frontCnt[back]++;
        }

        topologySort();

        bw.flush();
        bw.close();
        br.close();
    }

    private static void topologySort() throws IOException {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (frontCnt[i] == 0) {
                pq.offer(i);
            }
        }

        while (pq.size() > 0) {
            int cur = pq.poll();
            bw.write(cur+" ");
            PriorityQueue<Integer> l = ls[cur];
            for (Integer integer : l) {
                if (--frontCnt[integer] == 0) {
                    pq.offer(integer);
                }
            }
        }

    }

}