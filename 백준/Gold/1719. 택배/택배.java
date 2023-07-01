import java.io.*;
import java.util.*;

public class Main {

    static int INF = 1_000_000_001;

    static class Route {
        List<Integer> route;

        public Route(List route) {
            this.route = route;
        }

        public List<Integer> merge(List<Integer> other) {

            LinkedList<Integer> merged = new LinkedList<>();

            int size = route.size();
            for (int i = 0; i < size; i++) {
                merged.add(route.get(i));
            }
            int osize = other.size();
            for (int i = 1; i < osize; i++) {
                merged.add(other.get(i));
            }

            return merged;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (r == c) continue;
                board[r][c] = INF;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (board[a][b] > dist) {
                board[a][b] = dist;
            }
            if (board[b][a] > dist) {
                board[b][a] = dist;
            }
        }

        Route[][] routes = new Route[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                LinkedList<Integer> linkedList = new LinkedList<Integer>();
                linkedList.add(i);
                linkedList.add(j);
                routes[i][j] = new Route(linkedList);
            }
        }

        // 경 출 도
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k) continue;
                for (int j = 1; j <= N; j++) {
                    if (j == k) continue;

                    if (board[i][j] > board[i][k] + board[k][j]) {
                        board[i][j] = board[i][k] + board[k][j];
                        routes[i][j].route = routes[i][k].merge(routes[k][j].route);
                    }

                }
            }
        }


        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (r == c) {
                    bw.write("- ");
                    continue;
                } else if (board[r][c] == INF){
                    bw.write("- ");
                    continue;
                }
                List<Integer> rt = routes[r][c].route;
                bw.write(rt.get(1)+" ");
            }
                bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}