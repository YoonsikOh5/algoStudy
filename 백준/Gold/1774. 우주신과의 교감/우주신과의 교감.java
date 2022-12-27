import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // N 우주신들의 개수, M 이미 연결된 신들과의 통로의 개수
    static int N, M;
    static long[][] xyarr;
    static boolean visited[];
    static int visitedCnt;
    static double[][] adjMatrix;
    static double distSum;
    static double dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 0번 인덱스 버림
        xyarr = new long[N + 1][2];
        visited = new boolean[N + 1];
        visitedCnt = 0;
        distSum = 0;
        adjMatrix = new double[N + 1][N + 1];
        dist = new double[N + 1];
        Arrays.fill(dist, Double.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            xyarr[i][0] = Long.parseLong(st.nextToken());
            xyarr[i][1] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                long d0 = (xyarr[i][0] - xyarr[j][0]) * (xyarr[i][0] - xyarr[j][0]);
                long d1 = (xyarr[i][1] - xyarr[j][1]) * (xyarr[i][1] - xyarr[j][1]);
                long ds = d0 + d1;
                adjMatrix[i][j] = adjMatrix[j][i] = Math.sqrt(ds);
            }
        }


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            adjMatrix[left][right] = 0;
            adjMatrix[right][left] = 0;
        }

        if (N != 0) {
            prim();
        }

        System.out.printf("%.2f", (double) Math.round(distSum * 100) / 100);
//        bw.write(String.format("%.2f", distSum) + "");
//        bw.flush();
//        bw.close();
        br.close();

    }

    static void prim() {

        int minidx = -1;
        double mindist = Double.MAX_VALUE;

        dist[1] = 0;
        for (int j = 2; j <= N; j++) {
            dist[j] = Math.min(dist[j], adjMatrix[1][j]);
            if (mindist > dist[j]) {
                mindist = dist[j];
                minidx = j;
            }
        }
        visited[1] = true;
        visitedCnt++;


        if (visited[minidx] == false) {
            distSum += mindist;
            visited[minidx] = true;
            visitedCnt++;
        }

        while (visitedCnt < N) {
            visited[minidx] = true;
            int nextidx = minidx;
            mindist = Double.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (i == nextidx) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }
                dist[i] = Math.min(dist[i], adjMatrix[nextidx][i]);
                if (mindist > dist[i]) {
                    mindist = dist[i];
                    minidx = i;
                }
            }
            distSum += mindist;
            visitedCnt++;
        }

    }

}