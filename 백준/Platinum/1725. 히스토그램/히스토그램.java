import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;

    static int N;

    static Node[] minTree;

    static long result;

    static class Node {
        long minHeight;
        int minIndex;

        public Node(long minHeight, int minIndex) {
            this.minHeight = minHeight;
            this.minIndex = minIndex;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "minHeight=" + minHeight +
                    ", minIndex=" + minIndex +
                    '}';
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new long[N + 1];
        minTree = new Node[N * 4 + 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, N);
        findAnswer(1, N);

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            minTree[node] = new Node(arr[nodeLeft], nodeLeft);
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;

        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);

        Node leftChild = minTree[node * 2];
        Node rightChild = minTree[node * 2 + 1];

        if (leftChild.minHeight <= rightChild.minHeight) {
            minTree[node] = leftChild;
        } else {
            minTree[node] = rightChild;
        }
    }

    public static Node queryMin(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return new Node(1000000001, 0);
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return minTree[node];
        }

        int mid = (nodeLeft + nodeRight) / 2;
        Node leftQuery = queryMin(node * 2, nodeLeft, mid, queryLeft, queryRight);
        Node rightQuery = queryMin(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);

        if (leftQuery.minHeight <= rightQuery.minHeight) {
            return leftQuery;
        } else {
            return rightQuery;
        }
    }

    public static void findAnswer(int queryLeft, int queryRight) {
        if (queryLeft > queryRight) {
            return;
        }

        Node minNode = queryMin(1, 1, N, queryLeft, queryRight);
        result = Math.max(result, minNode.minHeight * (queryRight - queryLeft + 1));

        if (queryLeft == queryRight) {
            return;
        }

        if (queryLeft < minNode.minIndex) {
            findAnswer(queryLeft, minNode.minIndex -1);
        }
        if(minNode.minIndex < queryRight){
            findAnswer(minNode.minIndex + 1,queryRight);
        }
    }

}