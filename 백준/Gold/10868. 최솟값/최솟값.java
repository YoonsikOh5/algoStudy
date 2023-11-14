import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] minTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        minTree = new int[4 * (N + 1)];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, 1, N);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int queryLeft = Integer.parseInt(st.nextToken());
            int queryRight = Integer.parseInt(st.nextToken());
            int minResult = queryMin(1, 1, N, queryLeft, queryRight);
            bw.write(minResult + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int queryMin(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return Integer.MAX_VALUE;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return minTree[node];
        }
        int mid = (nodeLeft + nodeRight) / 2;
        int leftMin = queryMin(node * 2, nodeLeft, mid, queryLeft, queryRight);
        int rightMin = queryMin(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);
        return Math.min(leftMin, rightMin);
    }

    private static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            minTree[node] = arr[nodeLeft];
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);

        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
    }

}