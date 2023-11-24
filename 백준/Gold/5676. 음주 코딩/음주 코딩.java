import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] arr;
    static int[] mulArr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String curStr = null;
        while ((curStr = br.readLine())!=null && curStr.length() != 0) {
            StringTokenizer st = new StringTokenizer(curStr);

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N + 1];
            mulArr = new int[4 * (N + 1)];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur > 0) {
                    arr[i] = 1;
                } else if (cur == 0) {
                    arr[i] = 0;
                } else if (cur < 0) {
                    arr[i] = -1;
                }
            }

            init(1, 1, N);
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                char cur = st.nextToken().charAt(0);
                if (cur == 'C') {
                    int queryIndex = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());
                    update(1, 1, N, queryIndex, value);
                } else if (cur == 'P') {
                    int queryLeft = Integer.parseInt(st.nextToken());
                    int queryRight = Integer.parseInt(st.nextToken());
                    int curResult = queryMul(1, 1, N, queryLeft, queryRight);
                    if (curResult == -1) {
                        sb.append('-');
                    } else if (curResult == 0) {
                        sb.append('0');
                    } else if (curResult == 1) {
                        sb.append('+');
                    }
                }
            }

            bw.write(sb.toString() + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    private static int queryMul(int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return 1;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return mulArr[node];
        }


        int mid = (nodeLeft + nodeRight) / 2;
        int leftMul = queryMul(node * 2, nodeLeft, mid, queryLeft, queryRight);
        int rightMul = queryMul(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);
        return leftMul * rightMul;
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryIndex, int value) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            if (value > 0) {
                mulArr[node] = 1;
            } else if (value == 0) {
                mulArr[node] = 0;
            } else if (value < 0) {
                mulArr[node] = -1;
            }
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIndex, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex, value);
        mulArr[node] = mulArr[node * 2] * mulArr[node * 2 + 1];
    }

    private static void init(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            if (arr[nodeLeft] > 0) {
                mulArr[node] = 1;
            } else if (arr[nodeLeft] == 0) {
                mulArr[node] = 0;
            } else if (arr[nodeLeft] < 0) {
                mulArr[node] = -1;
            }
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        init(node * 2, nodeLeft, mid);
        init(node * 2 + 1, mid + 1, nodeRight);

        mulArr[node] = mulArr[node * 2] * mulArr[node * 2 + 1];
    }

}