import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long[] sumTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sumTree = new long[4 * (N + 1)];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 0) {
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                if (queryLeft > queryRight) {
                    int temp = queryLeft;
                    queryLeft = queryRight;
                    queryRight = temp;
                }
                long sumResult = querySum(1, 1, N, queryLeft, queryRight);
                bw.write(sumResult + "\n");
            } else if (cmd == 1) {
                int queryIndex = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                update(1, 1, N, queryIndex, value);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static long querySum(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 0;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return sumTree[node];
        }
        int mid = (nodeLeft + nodeRight) / 2;
        long leftSum = querySum(node * 2, nodeLeft, mid, queryLeft, queryRight);
        long rightSum = querySum(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);
        return leftSum + rightSum;
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryIndex, long value) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            sumTree[node] = value;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIndex, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex, value);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }


}