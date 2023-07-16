import java.io.*;
import java.util.*;

public class Main {

    static class ClassStat implements Comparable<ClassStat> {
        int classNum;
        int stat;

        public ClassStat(int classNum, int stat) {
            this.classNum = classNum;
            this.stat = stat;
        }

        @Override
        public int compareTo(ClassStat o) {
            return this.stat - o.stat;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        PriorityQueue<ClassStat> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                pq.offer(new ClassStat(i, Integer.parseInt(st.nextToken())));
            }
        }

        int[] arr = new int[N + 1];
        Arrays.fill(arr, -1);
        int cnt = 0;
        int resultMin = Integer.MAX_VALUE;

        Queue<ClassStat> q = new LinkedList<>();

        while (pq.size() > 0) {
            ClassStat poll = pq.poll();
            int classNum = poll.classNum;
            int stat = poll.stat;

            if (arr[classNum] == -1) {
                cnt++;
            } else {
                while (q.size() > 0 && q.peek().classNum == classNum) {
                    q.poll();
                }
            }
            arr[classNum] = stat;
            q.offer(poll);

            if(cnt==N){
                while (q.size() > 0 && arr[q.peek().classNum]!=q.peek().stat){
                    q.poll();
                }
                resultMin = Math.min(resultMin, (poll.stat - q.peek().stat));
            }

        }

        bw.write(resultMin+"");
        bw.flush();
        bw.close();
        br.close();
    }


}