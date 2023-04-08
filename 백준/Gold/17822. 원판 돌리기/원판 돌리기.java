import java.io.*;
import java.util.*;

public class Main {

    static int N, M, T;

    static class CircleBoard {

        int[][] circles;

        public CircleBoard(int N, int M) {
            circles = new int[N + 1][M + 1];
        }

        public void rotate(int x, int d, int k) {
            for (int i = x; i <= N; i += x) {
                // 시계
                if (d == 0) {
                    int[] circle = circles[i];
                    int[] nCircle = new int[M + 1];
                    int idx = 1;
                    for (int s = (M - k + 1); s <= M; s++) {
                        nCircle[idx] = circle[s];
                        idx++;
                    }
                    for (int s = 1; s <= M - k; s++) {
                        nCircle[idx] = circle[s];
                        idx++;
                    }
                    circles[i] = nCircle;
                    // 반시계
                } else if (d == 1) {
                    int[] circle = circles[i];
                    int[] nCircle = new int[M + 1];
                    int idx = 1;
                    for (int s = k + 1; s <= M; s++) {
                        nCircle[idx] = circle[s];
                        idx++;
                    }
                    for (int s = 1; s <= k; s++) {
                        nCircle[idx] = circle[s];
                        idx++;
                    }
                    circles[i] = nCircle;
                }
            }

        }

        public boolean Linked() {
            boolean[][] visited = new boolean[N + 1][M + 1];
            boolean[][] linked = new boolean[N + 1][M + 1];
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= M; c++) {
                    if (circles[r][c] != 0 && visited[r][c] == false) {
                        Queue<RC> q = new LinkedList<>();
                        q.add(new RC(r, c));
                        int cur = circles[r][c];
                        visited[r][c] = true;
                        while (q.size() > 0) {
                            RC poll = q.poll();
                            for (int d = 0; d < 4; d++) {
                                int nr = poll.r + dr[d];
                                int nc = poll.c + dc[d];
                                if (nc == M + 1) {
                                    nc = 1;
                                } else if (nc == 0) {
                                    nc = M;
                                }
                                if (nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
                                    if (cur == circles[nr][nc] && visited[nr][nc] == false) {
                                        linked[r][c] = true;
                                        visited[nr][nc] = true;
                                        linked[nr][nc] = true;
                                        q.add(new RC(nr, nc));
                                    }
                                }
                            }
                        } // while
                    }
                }
            }
            boolean haveLink = false;
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= M; c++) {
                    if (linked[r][c] == true) {
                        haveLink = true;
                        circles[r][c] = 0;
                    }
                }
            }

            return haveLink;
        }

        public void findAverage() {
            int sum = 0;
            int cnt = 0;
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= M; c++) {
                    if (circles[r][c] != 0) {
                        sum += circles[r][c];
                        cnt++;
                    }
                }
            }
            if(cnt==0){
                return;
            }
            int avg = sum / cnt;
            int mod = sum % cnt;
            if(mod==0){
                for (int r = 1; r <= N; r++) {
                    for (int c = 1; c <= M; c++) {
                        if(circles[r][c]==0){
                            continue;
                        }
                        if (circles[r][c] > avg) {
                            circles[r][c] -= 1;
                        } else if(circles[r][c] < avg){
                            circles[r][c] += 1;
                        }
                    }
                }
            } else {
                for (int r = 1; r <= N; r++) {
                    for (int c = 1; c <= M; c++) {
                        if(circles[r][c]==0){
                            continue;
                        }
                        if (circles[r][c] > avg) {
                            circles[r][c] -= 1;
                        } else if(circles[r][c] <= avg){
                            circles[r][c] += 1;
                        }
                    }
                }
            }

        }
    }

    static class RC {
        int r;
        int c;

        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        CircleBoard circleBoard = new CircleBoard(N, M);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                circleBoard.circles[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            circleBoard.rotate(x, d, k);
            if (!circleBoard.Linked()) {
                circleBoard.findAverage();
            }
        }
//        for (int[] circle : circleBoard.circles) {
//            System.out.println(Arrays.toString(circle));
//        }
        int sum = 0;
        for (int[] circle : circleBoard.circles) {
            for (int i : circle) {
                sum += i;
            }
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
