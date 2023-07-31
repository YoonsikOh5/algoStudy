import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static HashMap<Integer, Integer> stairMap;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stairMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            stairMap.put(start, end);
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            stairMap.put(start, end);
        }

        bfs(1);

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Snake {
        int num;
        int moveCnt;

        public Snake(int num, int moveCnt) {
            this.num = num;
            this.moveCnt = moveCnt;
        }
    }

    static int result;
    private static void bfs(int start) {
        Queue<Snake> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        q.offer(new Snake(start, 0));
        visited[1] = true;

        while (q.size() > 0) {
            Snake poll = q.poll();
            int curnum = poll.num;
            int curMoveCnt = poll.moveCnt;

            for (int i = 1; i <= 6; i++) {
                int nnum = curnum + i;

                if (nnum < 100) {
                    if (visited[nnum] == false) {
                        Integer orDefault = stairMap.getOrDefault(nnum, nnum);
                        q.offer(new Snake(orDefault, curMoveCnt + 1));
                        visited[orDefault] = true;
                    }
                } else if(nnum==100){
                    result = curMoveCnt+1;
                    return;
                }
            }
        }

    }

}