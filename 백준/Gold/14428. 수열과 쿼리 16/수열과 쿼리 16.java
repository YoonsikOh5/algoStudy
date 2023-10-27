import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static IdxMin[] minTree;


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        minTree = new IdxMin[4 * N+4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, N);

        M = Integer.parseInt(br.readLine());


        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int i = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                update(1, 1, N, i, v);

            } else if (cmd == 2) {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());

                IdxMin idxMin = queryMin(1, 1, N, i, j);
                bw.write(idxMin.minIdx + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            minTree[node] = new IdxMin(nodeLeft, arr[nodeLeft]);
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;

        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);

        IdxMin idxMinLeft = minTree[node * 2];
        IdxMin idxMinRight = minTree[node * 2+1];
        if(idxMinLeft.minValue < idxMinRight.minValue){
            minTree[node] = idxMinLeft;
        } else if(idxMinLeft.minValue > idxMinRight.minValue){
            minTree[node] = idxMinRight;
        } else  {
            if(idxMinLeft.minIdx < idxMinRight.minIdx){
                minTree[node] = idxMinLeft;
            } else {
                minTree[node] = idxMinRight;
            }
        }
    }

    static void update(int node, int nodeLeft, int nodeRight, int queryIndex, int value) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            minTree[node].minValue = value;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;

        update(node * 2, nodeLeft, mid, queryIndex, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex, value);

        IdxMin idxMinLeft = minTree[node * 2];
        IdxMin idxMinRight = minTree[node * 2+1];
        if(idxMinLeft.minValue < idxMinRight.minValue){
            minTree[node] = idxMinLeft;
        } else if(idxMinLeft.minValue > idxMinRight.minValue){
            minTree[node] = idxMinRight;
        } else{
            if(idxMinLeft.minIdx < idxMinRight.minIdx){
                minTree[node] = idxMinLeft;
            } else {
                minTree[node] = idxMinRight;
            }
        }
    }

    static class IdxMin {
        int minIdx;
        int minValue;

        public IdxMin(int minIdx, int minValue) {
            this.minIdx = minIdx;
            this.minValue = minValue;
        }
    }

    static IdxMin queryMin(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return new IdxMin(0,Integer.MAX_VALUE);
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return minTree[node];
        }

        int mid = (nodeLeft + nodeRight) / 2;
        IdxMin left = queryMin(node * 2, nodeLeft, mid, queryLeft, queryRight);
        IdxMin right = queryMin(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);

        if(left.minValue < right.minValue){
            return left;
        } else if(left.minValue > right.minValue){
            return right;
        } else{
            if(left.minIdx < right.minIdx){
                return left;
            } else {
                return right;
            }
        }

    }

}