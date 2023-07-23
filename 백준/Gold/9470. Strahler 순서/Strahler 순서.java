import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] backLsArr;
    static int[] frontArr;
    static Strahler[] strahlerArr;
    static Queue<Integer> q;
    static int resultStr;

    static class Strahler {
        int curMaxStrahler;
        int maxStrahlerCnt;

        public Strahler(int curMaxStrahler, int maxStrahlerCnt) {
            this.curMaxStrahler = curMaxStrahler;
            this.maxStrahlerCnt = maxStrahlerCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());


        for (int i = 1; i <= TC; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            backLsArr = new List[M + 1];
            strahlerArr = new Strahler[M + 1];
            frontArr = new int[M + 1];

            for (int b = 0; b <= M; b++) {
                backLsArr[b] = new LinkedList<>();
                strahlerArr[b] = new Strahler(0,0);
            }



            for (int j = 1; j <= P; j++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                frontArr[end]++;
                backLsArr[start].add(end);
            }

            q = new LinkedList<>();

            for (int s = 1; s <= M; s++) {
                if (frontArr[s] == 0) {
                    strahlerArr[s] = new Strahler(1, 1);
                    q.offer(s);
                }
            }

            topologySort();

            bw.write(K + " " + strahlerArr[M].curMaxStrahler + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void topologySort() {

        while (q.size() > 0) {
            Integer poll = q.poll();

            Strahler strahler = strahlerArr[poll];
            int curStarhler = strahler.curMaxStrahler;

            List<Integer> integers = backLsArr[poll];

            for (Integer integer : integers) {
                frontArr[integer]--;

                if (strahlerArr[integer].curMaxStrahler < curStarhler) {
                    strahlerArr[integer].curMaxStrahler = curStarhler;
                    strahlerArr[integer].maxStrahlerCnt = 1;
                } else if (strahlerArr[integer].curMaxStrahler == curStarhler) {
                    strahlerArr[integer].maxStrahlerCnt++;
                }

                if (frontArr[integer] == 0) {
                    if (strahlerArr[integer].maxStrahlerCnt > 1) {
                        strahlerArr[integer].curMaxStrahler++;
                        strahlerArr[integer].maxStrahlerCnt = 1;
                    }
                    q.offer(integer);
                }
            }
        }
    }

}