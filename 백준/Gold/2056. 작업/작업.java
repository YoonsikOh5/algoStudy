import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] backLsArr;
    static int[] frontArr;
    static int[] timeArr;
    static PriorityQueue<WorkInProgress> wpq;
    static int totalEndTime;

    static class WorkInProgress implements Comparable<WorkInProgress> {
        int num;
        int endTime;

        public WorkInProgress(int num, int endTime) {
            this.num = num;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(WorkInProgress o) {
            return this.endTime - o.endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        backLsArr = new List[N + 1];

        frontArr = new int[N + 1];
        timeArr = new int[N + 1];

        wpq = new PriorityQueue<>();

        for (int i = 0; i <= N; i++) {
            backLsArr[i] = new LinkedList<Integer>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            timeArr[i] = time;
            int frontCnt = Integer.parseInt(st.nextToken());
            frontArr[i] = frontCnt;
            if (frontCnt == 0) {
                wpq.offer(new WorkInProgress(i, time));
            }
            for (int j = 1; j <= frontCnt; j++) {
                int front = Integer.parseInt(st.nextToken());
                backLsArr[front].add(i);
            }
        }

        totalEndTime = 0;
        topologySort();

        bw.write(totalEndTime +"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void topologySort() {

        while (wpq.size() > 0) {
            WorkInProgress poll = wpq.poll();

            int endTime = poll.endTime;
            int num = poll.num;

            totalEndTime = Math.max(totalEndTime,endTime);

            List<Integer> integers = backLsArr[num];

            for (Integer integer : integers) {
                frontArr[integer]--;

                if (frontArr[integer] == 0) {
                    wpq.offer(new WorkInProgress(integer, endTime + timeArr[integer]));
                }
            }
        }
    }

}