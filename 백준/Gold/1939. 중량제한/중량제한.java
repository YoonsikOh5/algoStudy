import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int F1, F2;

    static List<Road>[] roads;

    static class Road {
        int start;
        int end;
        int weight;

        public Road(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        roads = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            roads[i] = new LinkedList<Road>();
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            roads[A].add(new Road(A, B, C));
            roads[B].add(new Road(B, A, C));
            min = Math.min(min, C);
            max = Math.max(max, C);
        }
        st = new StringTokenizer(br.readLine());
        F1 = Integer.parseInt(st.nextToken());
        F2 = Integer.parseInt(st.nextToken());

        // min~max
        int left = min;
        int right = max;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean able = bfs(mid);
            if (able) {
                answer = mid;
                left = mid + 1;
            } else if (!able) {
                right = mid - 1;
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bfs(int mid) {

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[F1] = true;
        q.offer(F1);

        while (q.size() > 0) {
            Integer poll = q.poll();

            List<Road> road = roads[poll];

            for (Road rd : road) {
                if (visited[rd.end] == false && rd.weight >= mid) {
                    if (rd.end == F2) {
                        return true;
                    }
                    visited[rd.end] = true;
                    q.offer(rd.end);
                }
            }
        }

        return false;
    }

}