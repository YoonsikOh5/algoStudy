import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] arr;
    static int[] sumTree;
    static long resultMid;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        sumTree = new int[65536 * 4];

        // K-1까지는 그냥 채워 넣기
        for (int i = 1; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            update(1, 0, 65536, num, 1);
            arr[i] = num;
        }

        int target = (K + 1) / 2;

        for (int i = K; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            update(1, 0, 65536, num, 1);
            arr[i] = num;
            // 찾기
            queryMid(1, 0, 65536, target);
            update(1, 0, 65536, arr[i - (K - 1)], -1);
        }


        bw.write(resultMid + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void queryMid(int node, int nodeLeft, int nodeRight, int target) {
        if (nodeLeft == nodeRight) {
            resultMid += nodeLeft;
            return;
        }

        int leftSum = sumTree[node * 2];
        int rightSum = sumTree[node * 2 + 1];

        int mid = (nodeLeft + nodeRight) / 2;
        // 오른쪽으로
        if (leftSum < target) {
            queryMid(node * 2 + 1, mid + 1, nodeRight, target - leftSum);
        } else {
            // 왼쪽으로
            queryMid(node * 2, nodeLeft, mid, target);
        }
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryIndex, int value) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            sumTree[node] += value;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIndex, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex, value);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }
}