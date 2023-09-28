import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] reps;

    static class Edge {
        int left;
        int right;
        int len;

        public Edge(int left, int right, int len) {
            this.left = left;
            this.right = right;
            this.len = len;
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.len - o1.len;
            }
        });

        init();

        int relation = 0;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(d==1){
                relation++;
                union(a,b);
            } else if(d==0){
                pq.offer(new Edge(a,b,c));
            }
        }

        int result = 0;
        while (relation < N-1){
            Edge poll = pq.poll();
            int left = poll.left;
            int right = poll.right;
            int len = poll.len;

            if(union(left, right)){
                relation++;
            } else {
                result += len;
            }
        }
        while (pq.size()>0){
            Edge poll = pq.poll();
            result += poll.len;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

    private static void init() {
        reps = new int[N+1];
        for(int i = 1; i <= N; i++){
            reps[i] = i;
        }
    }

    private static int findReps(int i){
        if(reps[i]==i){
            return i;
        } else {
            return reps[i] = findReps(reps[i]);
        }
    }

    private static boolean union(int a, int b){
        if(findReps(a)==findReps(b)){
            return false;
        } else {
            reps[findReps(a)] = findReps(b);
            return true;
        }
    }
}