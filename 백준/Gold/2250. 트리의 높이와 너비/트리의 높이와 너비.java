import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Node[] nodeArr;
    static boolean[] visited;
    static int headnum;
    static int curRow;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 0번은 레벨 탐색용으로 쓸꺼임
        nodeArr = new Node[N + 1];

        for (int i = 0; i <= N; i++) {
            nodeArr[i] = new Node(i);
        }

        // 트리 연결 완
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodenum = Integer.parseInt(st.nextToken());
            int leftc = Integer.parseInt(st.nextToken());
            int rightc = Integer.parseInt(st.nextToken());

            if (leftc != -1) {
                nodeArr[nodenum].leftChild = nodeArr[leftc];
                merge(nodeArr[nodenum], nodeArr[leftc]);
            }
            if (rightc != -1) {
                nodeArr[nodenum].rightChild = nodeArr[rightc];
                merge(nodeArr[nodenum], nodeArr[rightc]);
            }
        }

        q = new LinkedList<Integer>();

        headnum = nodeArr[1].getRep().nodeNum;
        curRow = 1;
        lsmap = new HashMap<Integer, LeftRight>();
        dfs(nodeArr[headnum], 1);

        for (Map.Entry<Integer, LeftRight> clr : lsmap.entrySet()) {
            int curwidth = clr.getValue().right - clr.getValue().left + 1;
            if (maxwidth < curwidth) {
                maxwidth = curwidth;
                maxlevel = clr.getKey();
            } else if (maxwidth == curwidth) {
                Integer cur = clr.getKey();
                maxlevel = Math.min(maxlevel, cur);
            }
        }
        System.out.println(maxlevel + " " + maxwidth);
    }

    static Queue<Integer> q;
    // 각 level의 left right row
    static Map<Integer, LeftRight> lsmap;
    static int maxlevel = 1, maxwidth = 0;

    static class LeftRight {
        int left;
        int right;

        public LeftRight(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    // 중위순회
    static void dfs(Node parent, int level) {
        if (parent == null) {
            return;
        }
        dfs(parent.leftChild, level + 1);
        LeftRight curLeftRight = lsmap.getOrDefault(level, new LeftRight(N + 1, 0));
        if (curLeftRight.left > curRow) {
            curLeftRight.left = curRow;
        }
        if (curLeftRight.right < curRow) {
            curLeftRight.right = curRow;
        }
        lsmap.put(level, curLeftRight);
        curRow++;
        dfs(parent.rightChild, level + 1);
    }

    static void merge(Node parent, Node child) {

        if (!(parent.getRep() == child.getRep())) {
            child.getRep().repNode = parent.getRep();
        }

    }

    static class Node {
        int nodeNum;
        Node leftChild;
        Node rightChild;

        //
        Node repNode;

        public Node(int nodeNum) {
            this.nodeNum = nodeNum;
            this.leftChild = null;
            this.rightChild = null;
            this.repNode = this;
        }

        // 유니온파인드로 헤드노드찾기
        Node getRep() {
            if (repNode == this) {
                return this;
            }
            return repNode = repNode.getRep();
        }

    }

}