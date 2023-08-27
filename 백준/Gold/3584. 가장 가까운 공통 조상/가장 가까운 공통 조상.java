import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

        static Node parentZero = new Node();
        static Node[] nodeArr;
        static int N;
        static TreeMap<Integer, List<Integer>> depthNodeNumhm;

        static class Node {

            // parent[0] 2^0 = 1 번째 조상
            // parent[1] 2^1 = 2 번째 조상
            // parent[2] 2^2 = 4 번째 조상
            // ... 이렇게 점프 뛰기 위해 조상 설정
            Node[] parent;
            List<Node> childs;

            int num;

            int depth;

            public Node() {
                this.parent = new Node[20];
                this.parent[0] = parentZero;
                childs = new ArrayList<>();
            }

            public void setDepth() {
                if(depthNodeNumhm.containsKey(this.depth)){
                    depthNodeNumhm.get(this.depth).add(this.num);
                } else {
                    depthNodeNumhm.put(this.depth,new LinkedList());
                    depthNodeNumhm.get(this.depth).add(this.num);
                }
                for (Node child : childs) {
                    child.depth = this.depth+1;
                    child.setDepth();
                }
            }
        }

        public static void main(String args[]) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int T = Integer.parseInt(br.readLine());

            for (int test_case = 1; test_case <= T; test_case++) {

                N = Integer.parseInt(br.readLine());

                nodeArr = new Node[N + 1];
                nodeArr[0] = parentZero;
                for(int i = 0; i < 20; i++){
                    nodeArr[0].parent[i] = nodeArr[0];
                }
                for (int i = 1; i <= N; i++) {
                    nodeArr[i] = new Node();
                    nodeArr[i].num = i;
                }
                for (int i = 1; i < N; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int parent = Integer.parseInt(st.nextToken());
                    int child = Integer.parseInt(st.nextToken());
                    nodeArr[parent].childs.add(nodeArr[child]);
                    nodeArr[child].parent[0] = nodeArr[parent];
                }

                Node root = parentZero;
                depthNodeNumhm = new TreeMap<>();
                for(int i = 1; i < N; i++){
                    if(nodeArr[i].parent[0]==parentZero){
                        root = nodeArr[i];
                        root.depth = 0;
                        root.setDepth();
                        break;
                    }
                }
                StringTokenizer st = new StringTokenizer(br.readLine());
                int lcaA = Integer.parseInt(st.nextToken());
                int lcaB = Integer.parseInt(st.nextToken());

                for (int y = 1; y < 20; y++) {
                    for (List<Integer> value : depthNodeNumhm.values()) {
                        for (Integer x : value) {
                           nodeArr[x].parent[y] = nodeArr[nodeArr[x].parent[y - 1].num].parent[y - 1];
                        }
                    }
                }

                long l = doLCA(lcaA, lcaB);


                bw.write(l+"\n");

            }
            bw.flush();
            bw.close();
            br.close();

        }


        private static long doLCA(int pre, int cur) {
            Node preNode = nodeArr[pre];
            Node curNode = nodeArr[cur];
            // preNode의 depth를 더 낮게 해서 편하게 할려고
            if (preNode.depth > curNode.depth) {
                preNode = nodeArr[cur];
                curNode = nodeArr[pre];
            }
            // curNode의 parent가 prenode이면 당연히 LCA도 1
            if (curNode.parent[0] == preNode) {
                return preNode.num;
            }
            for (int i = 19; i >= 0; i--) {
                if (curNode.depth - preNode.depth >= (1 << i)) {
                    curNode = curNode.parent[i];
                    if(curNode==preNode){
                        return curNode.num;
                    }
                }
            }
            if (curNode.parent[0] != preNode.parent[0]) {
                for (int i = 19; i >= 0; i--) {
                    if (preNode.parent[i] != curNode.parent[i]) {
                        preNode = preNode.parent[i];
                        curNode = curNode.parent[i];
                    }
                }
            }
            if (preNode.parent[0] == curNode.parent[0]) {
                return preNode.parent[0].num;
            }
            return 0;
        }

    }