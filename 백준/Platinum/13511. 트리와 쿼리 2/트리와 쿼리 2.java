import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Node[] nodeArr;
    static Node parentZero = new Node();
    static List<Edge>[] edgeList;
    static boolean[] visited;

    static class Edge {
        int start;
        int end;
        long dist;

        public Edge(int start, int end, long dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    static class Node {
        Node[] parent;
        List<Node> childs;

        int num;

        int depth;

        // 위에서부터의 dist
        long dist;

        public Node() {
            this.parent = new Node[20];
            this.parent[0] = parentZero;
            childs = new ArrayList<>();
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        nodeArr = new Node[N + 1];
        nodeArr[0] = parentZero;
        for (int i = 0; i < 20; i++) {
            nodeArr[0].parent[i] = nodeArr[0];
        }

        for (int i = 1; i <= N; i++) {
            nodeArr[i] = new Node();
            nodeArr[i].num = i;
        }

        Node root = nodeArr[1];
        edgeList = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            edgeList[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            edgeList[a].add(new Edge(a, b, d));
            edgeList[b].add(new Edge(b, a, d));
        }

        visited[1] = true;
        makeTree();

        for (int y = 1; y < 20; y++) {
            for (int x = 1; x <= N; x++) {
                nodeArr[x].parent[y] = nodeArr[nodeArr[x].parent[y - 1].num].parent[y - 1];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int lcaA = Integer.parseInt(st.nextToken());
                int lcaB = Integer.parseInt(st.nextToken());
                long l = doLCA(lcaA, lcaB);
                bw.write(l + "\n");
            } else if (cmd == 2) {
                int lcaA = Integer.parseInt(st.nextToken());
                int lcaB = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                long l = doFindK(lcaA, lcaB, k);
                bw.write(l + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static long doFindK(int start, int end, int k) {
        int leftMovedCnt = 0;
        int rightMovedCnt = 0;
        Node startNode = nodeArr[start];
        Node endNode = nodeArr[end];
        if (k == 1 || k == 0) {
            return startNode.num;
        }
        if (startNode == endNode) {
            if (k == 1) {
                return startNode.num;
            } else if (k == 2) {
                return endNode.num;
            }
        }
        // 여기는 방향도 중요하니까 start end 바꾸지 말고 ㄱㄱ
        if (startNode.depth > endNode.depth) {
            for (int i = 19; i >= 0; i--) {
                if (startNode.depth - endNode.depth >= (1 << i)) {
                    leftMovedCnt += (1 << i);
                    startNode = startNode.parent[i];
                    if (startNode == endNode) {
                        Node originStartNode = nodeArr[start];
                        int originK = k - 1;
                        String binaryString = Integer.toBinaryString(originK);
                        int length = binaryString.length();
                        for (int s = length - 1; s >= 0; s--) {
                            int binaryNum = binaryString.charAt(s) - '0';
                            if (binaryNum == 1) {
                                int movingPow = (length - 1) - s;
                                originStartNode = originStartNode.parent[movingPow];
                            }
                        }
                        return originStartNode.num;
                    }
                }
            }
        }

        if (startNode.depth < endNode.depth) {
            for (int i = 19; i >= 0; i--) {
                if (endNode.depth - startNode.depth >= (1 << i)) {
                    rightMovedCnt += (1 << i);
                    endNode = endNode.parent[i];
                    if (startNode == endNode) {
                        Node originEndNode = nodeArr[end];
                        int originK = (rightMovedCnt + 1) - k;
                        String binaryString = Integer.toBinaryString(originK);
                        int length = binaryString.length();
                        for (int s = length - 1; s >= 0; s--) {
                            int binaryNum = binaryString.charAt(s) - '0';
                            if (binaryNum == 1) {
                                int movingPow = (length - 1) - s;
                                originEndNode = originEndNode.parent[movingPow];
                            }
                        }
                        return originEndNode.num;
                    }
                }
            }
        }


        if (startNode.parent[0] != endNode.parent[0]) {
            for (int i = 19; i >= 0; i--) {
                if (startNode.parent[i] != endNode.parent[i]) {
                    leftMovedCnt += (1 << i);
                    rightMovedCnt += (1 << i);
                    startNode = startNode.parent[i];
                    endNode = endNode.parent[i];
                }
            }
        }
        if (startNode.parent[0] == endNode.parent[0]) {
            leftMovedCnt += 1;
            rightMovedCnt += 1;

            // LCA 가 K번째 인 경우
            if (k == (leftMovedCnt + 1)) {
                return startNode.parent[0].num;
            } else if (k <= leftMovedCnt) {
                // k번째가 LCA 왼쪽인 경우
                Node originStartNode = nodeArr[start];
                int originK = k - 1;
                String binaryString = Integer.toBinaryString(originK);
                int length = binaryString.length();
                for (int s = length - 1; s >= 0; s--) {
                    int binaryNum = binaryString.charAt(s) - '0';
                    if (binaryNum == 1) {
                        int movingPow = (length - 1) - s;
                        originStartNode = originStartNode.parent[movingPow];
                    }
                }
                return originStartNode.num;
            } else {
                // K번째가 LCA 오른쪽인 경우
                Node originEndNode = nodeArr[end];
                int originK = (leftMovedCnt + rightMovedCnt + 1) - k;
                String binaryString = Integer.toBinaryString(originK);
                int length = binaryString.length();
                for (int s = length - 1; s >= 0; s--) {
                    int binaryNum = binaryString.charAt(s) - '0';
                    if (binaryNum == 1) {
                        int movingPow = (length - 1) - s;
                        originEndNode = originEndNode.parent[movingPow];
                    }
                }
                return originEndNode.num;
            }
        }
        return -1;
    }

    private static long doLCA(int pre, int cur) {
        long dist = 0;
        Node preNode = nodeArr[pre];
        Node curNode = nodeArr[cur];
        if (preNode == curNode) {
            return 0;
        }
        // curNode의 depth를 더 낮게 해서 편하게 할려고
        if (preNode.depth > curNode.depth) {
            preNode = nodeArr[cur];
            curNode = nodeArr[pre];
        }
        // curNode의 parent가 prenode이면 당연히 LCA도 prenode
        if (curNode.parent[0] == preNode) {
            return curNode.dist - preNode.dist;
        }

        for (int i = 19; i >= 0; i--) {
            if (curNode.depth - preNode.depth >= (1 << i)) {
                dist += curNode.dist - curNode.parent[i].dist;
                curNode = curNode.parent[i];
                if (curNode == preNode) {
                    return dist;
                }
            }
        }
        if (curNode.parent[0] != preNode.parent[0]) {
            for (int i = 19; i >= 0; i--) {
                if (preNode.parent[i] != curNode.parent[i]) {
                    dist += preNode.dist - preNode.parent[i].dist;
                    dist += curNode.dist - curNode.parent[i].dist;
                    preNode = preNode.parent[i];
                    curNode = curNode.parent[i];
                }
            }
        }
        if (preNode.parent[0] == curNode.parent[0]) {
            dist += preNode.dist - preNode.parent[0].dist;
            dist += curNode.dist - curNode.parent[0].dist;
            return dist;
        }
        return dist;
    }

    private static void makeTree() {
        Queue<Node> q = new LinkedList<>();
        q.offer(nodeArr[1]);

        while (q.size() > 0) {
            Node poll = q.poll();
            int cur = poll.num;

            List<Edge> edges = edgeList[cur];
            for (Edge edge : edges) {
                int child = edge.end;
                if (visited[child] == true) {
                    continue;
                }
                visited[child] = true;
                nodeArr[child].parent[0] = nodeArr[cur];
                nodeArr[cur].childs.add(nodeArr[child]);
                nodeArr[child].depth = poll.depth + 1;
                nodeArr[child].dist = poll.dist + edge.dist;
                q.offer(nodeArr[child]);
            }
        }

    }

}