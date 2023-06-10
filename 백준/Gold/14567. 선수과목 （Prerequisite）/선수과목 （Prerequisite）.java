import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] frontCnt;
    static List<Integer>[] backLs;
    static int[] results;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        frontCnt = new int[N+1];
        backLs = new List[N+1];

        for(int i = 0; i <= N; i++){
            backLs[i] = new LinkedList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            frontCnt[back]++;
            backLs[front].add(back);
        }

        results = new int[N+1];
        topologySort();
        for(int i = 1; i <= N; i++){
            bw.write(results[i]+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void topologySort() throws IOException {

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++){
            if(frontCnt[i]==0){
                q.offer(i);
            }
        }

        Queue<Integer> nextRoundQ = new LinkedList<Integer>();
        int round = 1;
        while (q.size() > 0) {
            Integer poll = q.poll();
            results[poll] = round;
            List<Integer> backL = backLs[poll];
            for (Integer backi : backL) {
                if(--frontCnt[backi]==0){
                    nextRoundQ.offer(backi);
                }
            }
            if(q.size()==0){
                round++;
                while (nextRoundQ.size()>0){
                    q.offer(nextRoundQ.poll());
                }
            }
        }

    }

}