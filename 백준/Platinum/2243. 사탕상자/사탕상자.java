import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] sumTree;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        // 1000000개의 맛의 세그먼트 트리 각 맛에는 현재 0개의 사탕이 들어가 있음
        // init을 할 필요가 없음 어차피 0개니까
        sumTree = new int[4000001];
        // init(1, 1, 1000000);

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int rank = Integer.parseInt(st.nextToken());
                // 꺼낸 사탕의 맛 출력
                int value = queryRank(1, 1, 1000000, rank);
                bw.write(value + "\n");
                update(1, 1, 1000000, value, -1);
            } else if (cmd == 2) {
                int value = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                // update
                update(1, 1, 1000000, value, amount);
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static int queryRank(int node, int nodeLeft, int nodeRight, int rank) {

        // left==right인 곳에 도착했다는 것은 찾는 rank가 있는 맛에 왔다는 것
        if(nodeLeft==nodeRight){
            return nodeLeft;
        }

        //
        int leftSum = sumTree[node * 2];
        int rightSum = sumTree[node * 2 + 1];
        int mid = (nodeLeft+nodeRight)/2;
        if(rank > leftSum){
            // rank보다 leftSum이 높으면 무조건 오른쪽에 있음
            // 오른쪽에서 rank-leftSum의 순위를 찾으면 됨
            return queryRank(node*2+1, mid+1, nodeRight, rank-leftSum);
        } else {
            // rank가 leftSum보다 작거나 같으면 무조건 왼쪽에 있음
            // rank는 그대로
            return queryRank(node*2, nodeLeft, mid, rank);
        }
    }

    private static void update(int node, int nodeLeft, int nodeRight, int queryIndex, int amount) {
        if (queryIndex < nodeLeft || nodeRight < queryIndex) {
            return;
        }

        if (nodeLeft == nodeRight) {
            sumTree[node] += amount;
            return;
        }

        int mid = (nodeLeft + nodeRight) / 2;
        update(node * 2, nodeLeft, mid, queryIndex, amount);
        update(node * 2 + 1, mid + 1, nodeRight, queryIndex, amount);
        
        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }
}