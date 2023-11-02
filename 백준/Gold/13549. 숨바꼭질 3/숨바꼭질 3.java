import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static boolean[] visited;
    static int result;

    static class Spot {
        int x;
        int time;

        public Spot(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        dijk();

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijk() {
        PriorityQueue<Spot> pq = new PriorityQueue<>(new Comparator<Spot>() {
            @Override
            public int compare(Spot o1, Spot o2) {
                return o1.time - o2.time;
            }
        });

        pq.offer(new Spot(N, 0));
        visited[N] = true;
        while (pq.size() > 0) {
            Spot poll = pq.poll();
            int time = poll.time;
            int x = poll.x;
            visited[x] = true;
            if (x == K) {
                result = time;
                return;
            }
            int[] arr = new int[3];
            arr[0] = x + 1;
            arr[1] = x - 1;
            arr[2] = 2 * x;
            for (int i = 0; i < 3; i++) {
                if (arr[i] >= 0 && arr[i] <= 100000) {
                    if (visited[arr[i]] == false) {
                        if (i == 2) {
                            pq.offer(new Spot(arr[i], time));
                        } else {
                            pq.offer(new Spot(arr[i], time + 1));
                        }
                    }
                }
            }
        }
    }

}