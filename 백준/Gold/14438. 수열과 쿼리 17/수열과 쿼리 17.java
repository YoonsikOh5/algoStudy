import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] minTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        minTree = new int[4 * (N + 1)];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 1, N);

        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int queryIndex = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                update(1, 1, N, queryIndex, value);
            } else if (cmd == 2) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                int minResult = queryMin(1, 1, N, queryLeft, queryRight);
                bw.write(minResult + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryIndex, int value) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            minTree[node] = value;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIndex, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex, value);

        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
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