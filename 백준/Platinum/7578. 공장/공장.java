import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static Map<Integer, Integer> upIdMap;

    static long[] sumTree;


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        // init 할 필요 없음 처음에는 다 0
        sumTree = new long[4 * N + 4];

        upIdMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int upNum = Integer.parseInt(st.nextToken());
            upIdMap.put(upNum, i);
        }

        st = new StringTokenizer(br.readLine());

        long resultSum = 0;
        for (int i = 1; i <= N; i++) {
            // sum 쿼리
            int downNum = Integer.parseInt(st.nextToken());
            Integer upId = upIdMap.get(downNum);

            // upId ~ 마지막 까지의 누적합을 계속 더해주면 됨
            resultSum += querySum(1, 1, N, upId, N);

            update(1, 1, N, upId);
        }

        bw.write(resultSum+"");
        bw.flush();
        bw.close();
        br.close();

    }

    private static long querySum(int node, int nodeLeft, int nodeRight, Integer queryLeft, int queryRight) {
        if(queryRight < nodeLeft || nodeRight < queryLeft){
            return 0;
        }

        if(queryLeft <= nodeLeft && nodeRight <= queryRight){
            return sumTree[node];
        }

        int mid = (nodeLeft + nodeRight) / 2;
        long leftSum = querySum(node * 2, nodeLeft, mid, queryLeft, queryRight);
        long rightSum = querySum(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);

        return leftSum+rightSum;
    }

    private static void update(int node, int nodeLeft, int nodeRight, Integer upId) {
        if (upId < nodeLeft || nodeRight < upId) {
            return;
        }

        if (nodeLeft == nodeRight) {
            sumTree[node] = 1;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, upId);
        update(node * 2 + 1, mid + 1, nodeRight, upId);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

}