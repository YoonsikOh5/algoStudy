import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int n, m, s, e;
    static int[][] matrix;
    static boolean[] visited;
    static int resultCnt = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        matrix = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        visited = new boolean[n + 1];

        bfs();

        bw.write(resultCnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int counter = -1;
        q.add(s);
        q.add(counter);
        visited[s] = true;
        while (q.size() > 0) {
            Integer cur = q.poll();
            if (cur == counter) {
                resultCnt++;
                if (q.size() != 0) {
                    q.offer(counter);
                }
                continue;
            }
            for (int i = 1; i <= n; i++) {
                if (matrix[cur][i] == 1) {
                    if (visited[i] == false) {
                        visited[i] = true;
                        q.offer(i);
                        if (i == e) {
                            resultCnt++;
                            return;
                        }
                    }
                }
            }
        }
        resultCnt = -1;
    }
}