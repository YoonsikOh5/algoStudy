import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int length;
    static char[] schoolGenderArr;
    static List<Edge>[] edgeArr;

    static class Edge {
        int start;
        int end;
        int distance;

        public Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        schoolGenderArr = new char[N+1];

        for (int i = 1; i <= N; i++){
            schoolGenderArr[i] = st.nextToken().charAt(0);
        }

        edgeArr = new List[N+1];
        for(int i = 0; i <= N; i++){
            edgeArr[i] = new LinkedList<Edge>();
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edgeArr[u].add(new Edge(u,v,d));
            edgeArr[v].add(new Edge(v,u,d));
        }
        doPrim();

        bw.write(length+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void doPrim() {
        // 1번부터 시작
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.distance-o2.distance;
            }
        });
        pq.offer(new Edge(1,1,0));
        length = 0;
        int selectedCnt = 0;

        while (pq.size()>0 && selectedCnt!=N){
            Edge poll = pq.poll();
            int curEnd = poll.end;
            if(visited[curEnd]==true){
                continue;
            }
            int distance = poll.distance;
            visited[curEnd] = true;
            selectedCnt++;
            length += distance;
            List<Edge> edges = edgeArr[curEnd];
            for (Edge edge : edges) {
                if(visited[edge.end]==false && (schoolGenderArr[edge.start]!=schoolGenderArr[edge.end])){
                    pq.offer(edge);
                }
            }
        }
        if(selectedCnt!=N){
            length = -1;
        }
    }
}