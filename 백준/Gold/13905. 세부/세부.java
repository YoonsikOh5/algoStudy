import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int N, M;
    static int s, e;
    static int[] reps;

    static PriorityQueue<Bridge> pq;
    static int resultWeight;

    static class Bridge implements Comparable<Bridge> {
        int left;
        int right;

        int weightLimit;

        public Bridge(int left, int right, int weightLimit) {
            this.left = left;
            this.right = right;
            this.weightLimit = weightLimit;
        }

        // 무게 최대 제한 내림차순
        @Override
        public int compareTo(Bridge o) {
            return o.weightLimit - this.weightLimit;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();

        reps = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            reps[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            pq.offer(new Bridge(h1, h2, k));
        }

        resultWeight = Integer.MAX_VALUE;

        doDijk();

        if (merge(s, e)) {
            bw.write(0 + "");
        } else {
            bw.write(resultWeight + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void doDijk() {

        int picked = 0;
        while (pq.size() > 0 && (picked != N - 1)) {
            Bridge poll = pq.poll();
            int left = poll.left;
            int right = poll.right;
            int weightLimit = poll.weightLimit;
            if (merge(left, right)) {
                picked++;
                resultWeight = Math.min(resultWeight, weightLimit);
            }
            if(findrep(s)==findrep(e)){
                break;
            }
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