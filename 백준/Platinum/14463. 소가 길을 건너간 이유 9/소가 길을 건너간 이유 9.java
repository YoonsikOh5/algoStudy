import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Map<Integer, Integer> hm;
    static int[] arr;
    static int[] sumTree;
    static boolean isExist;
    static long result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        hm = new HashMap<>();
        arr = new int[(2 * N) + 1];
        sumTree = new int[4 * (N + 1)];
        int index = 1;
        for (int i = 1; i <= (2 * N); i++) {
            int num = Integer.parseInt(br.readLine());
            if (!hm.containsKey(num)) {
                hm.put(num, index++);
            }
            arr[i] = num;
        }

        for (int i = 1; i <= (2 * N); i++) {
            int cur = arr[i];
            Integer target = hm.get(cur);
            update(1, 1, N, target);
            if (isExist) {
                // 앞쪽 찾기
                result += querySum(1, 1, N, target, N);
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long querySum(int node, int nodeLeft, int nodeRight, Integer queryLeft, int queryRight) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 0;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return sumTree[node];
        }
        int mid = (nodeLeft + nodeRight) / 2;
        long leftSum = querySum(node * 2, nodeLeft, mid, queryLeft, queryRight);
        long rightSum = querySum(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);

        return leftSum+rightSum;
    }

    private static void update(int node, int nodeLeft, int nodeRight, Integer target) {
        if (target < nodeLeft || nodeRight < target) {
            return;
        }

        if (nodeLeft == nodeRight) {
            if (sumTree[node] == 0) {
                sumTree[node] = 1;
                isExist = false;
            } else if (sumTree[node] == 1) {
                sumTree[node] = 0;
                isExist = true;
            }
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, target);
        update(node * 2 + 1, mid + 1, nodeRight, target);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }
}