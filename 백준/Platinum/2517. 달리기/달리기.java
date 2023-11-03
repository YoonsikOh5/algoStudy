import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] sumTree;
    static HashMap<Integer, Integer> hm;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        sumTree = new int[4 * 500000 + 8];

        long result = 0;
        int[] arr = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] sortArr = new int[N];
        hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            pq.offer(cur);
            arr[i] = cur;
        }
        for (int i = 0; i < N; i++) {
            hm.put(pq.poll(), i+1);
        }
        for (int i = 0; i < N; i++) {
            Integer cur = hm.get(arr[i]);
            updateTree(1, 1, 500001, cur);
            int rank = i - querySum(1, 1, 500001, cur + 1, 500001);
            rank++;

            bw.write(rank+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int querySum(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 0;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return sumTree[node];
        }
        int mid = (nodeLeft + nodeRight) / 2;
        int leftSum = querySum(node * 2, nodeLeft, mid, queryLeft, queryRight);
        int rightSum = querySum(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);

        return leftSum + rightSum;
    }

    private static void updateTree(int node, int nodeLeft, int nodeRight, int queryIndex) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }
        if (nodeLeft == nodeRight) {
            sumTree[node] = 1;
            return;
        }
        int mid = (nodeLeft + nodeRight) / 2;
        updateTree(node * 2, nodeLeft, mid, queryIndex);
        updateTree(node * 2 + 1, mid + 1, nodeRight, queryIndex);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

}