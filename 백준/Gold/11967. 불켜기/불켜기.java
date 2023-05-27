import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static List<RC>[][] ls;

    static boolean[][] ableMatrix;
    static boolean[][] visitedMatrix;
    static boolean[][] reachableMatrix;

    static int result;

    static class RC {
        int r;
        int c;

        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ls = new List[N + 1][N + 1];
        ableMatrix = new boolean[N + 1][N + 1];
        visitedMatrix = new boolean[N + 1][N + 1];
        reachableMatrix = new boolean[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                ls[r][c] = new LinkedList<RC>();
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //
            ls[x][y].add(new RC(a, b));
        }
        ableMatrix[1][1] = true;

        bfs();
        result = 0;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (ableMatrix[r][c] == true) {
                    result++;
                }
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static void bfs() {
        Queue<RC> q = new LinkedList<>();
        q.offer(new RC(1, 1));

        while (q.size() > 0) {
            RC poll = q.poll();
            int r = poll.r;
            int c = poll.c;
            // 일단 방문 했던 곳이면 다시 올 필요가 없으니 컨티뉴
            if (visitedMatrix[r][c] == true) {
                continue;
            }
            // 첫 방문이면 visitedMatrix[r][c] 넣어주고
            visitedMatrix[r][c] = true;


            // 지금 방문한 곳에서 스위치 켜주기
            for (RC rc : ls[r][c]) {
                // 스위치 켠 곳은 ableMatirx가 true로
                ableMatrix[rc.r][rc.c] = true;
                // 방문은 안했고
                if (visitedMatrix[rc.r][rc.c] == false) {
                    // 갈 수는 있는 곳이면
                    if (reachableMatrix[rc.r][rc.c] == true) {
                        // 바로 q에 넣어주기
                        q.offer(new RC(rc.r, rc.c));
                    }
                }
            }

            // 방문한 곳에서 4방 탐색
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
                    // 방문한 곳에서 4방 탐색해서 갈 수 있으면 reachableMatrix true
                    reachableMatrix[nr][nc] = true;
                    // 불이 켜져있고
                    if (ableMatrix[nr][nc] == true) {
                        // 방문 안했으면
                        if (visitedMatrix[nr][nc] == false) {
                            // q에 넣어주기
                            // 이걸 함으로써 첫 사방탐색 때는 불이 안켜져서 못갔는데
                            // 나중에 불을 켜서 갈 수 있는 곳이 생기면 챙겨 줄 수 있음
                            q.offer(new RC(nr, nc));
                        }
                    }
                }
            }
        }
    }
}
