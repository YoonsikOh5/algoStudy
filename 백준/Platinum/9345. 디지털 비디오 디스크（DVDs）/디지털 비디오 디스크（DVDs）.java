import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] arr;
    // minmaxTree[i][0] 최솟값 [i][1] 최댓값
    static int[][] minmaxTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i;
            }
            minmaxTree = new int[4 * N][2];

            init(1, 0, N - 1);

            for (int k = 1; k <= K; k++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                if (cmd == 0) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int curA = arr[a];
                    int curB = arr[b];
                    update(1, 0, N - 1, a, curB);
                    update(1, 0, N - 1, b, curA);
                    arr[a] = curB;
                    arr[b] = curA;
                } else if (cmd == 1) {
                    int queryLeft = Integer.parseInt(st.nextToken());
                    int queryRight = Integer.parseInt(st.nextToken());
                    int[] minmax = queryMinMax(1, 0, N - 1, queryLeft, queryRight);
                    if (minmax[0] < queryLeft || queryRight < minmax[1]) {
                        bw.write("NO\n");
                    } else {
                        bw.write("YES\n");
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] queryMinMax(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            int[] minMax = new int[2];
            minMax[0] = Integer.MAX_VALUE;
            minMax[1] = 0;
            return minMax;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return minmaxTree[node];
        }

        int mid = (nodeLeft + nodeRight) / 2;
        int[] leftMinMax = queryMinMax(node * 2, nodeLeft, mid, queryLeft, queryRight);
        int[] rightMinMax = queryMinMax(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);

        int[] minMax = new int[2];
        minMax[0] = Math.min(leftMinMax[0], rightMinMax[0]);
        minMax[1] = Math.max(leftMinMax[1], rightMinMax[1]);
        return minMax;
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryIndex, int value) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            minmaxTree[node][0] = value;
            minmaxTree[node][1] = value;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIndex, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex, value);

        minmaxTree[node][0] = Math.min(minmaxTree[node * 2][0], minmaxTree[node * 2 + 1][0]);
        minmaxTree[node][1] = Math.max(minmaxTree[node * 2][1], minmaxTree[node * 2 + 1][1]);
    }

    private static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            minmaxTree[node][0] = arr[nodeLeft];
            minmaxTree[node][1] = arr[nodeLeft];
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);

        minmaxTree[node][0] = Math.min(minmaxTree[node * 2][0], minmaxTree[node * 2 + 1][0]);
        minmaxTree[node][1] = Math.max(minmaxTree[node * 2][1], minmaxTree[node * 2 + 1][1]);
    }
}