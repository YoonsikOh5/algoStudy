import java.io.*;
import java.util.*;

public class Main {

    static int H, W, N;
    static int[][] board;
    static Mouse mouse;

    static class Mouse {
        int totalstep;
        int health;
        int curr;
        int curc;

        public Mouse(int curr, int curc) {
            this.health = 1;
            this.curr = curr;
            this.curc = curc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[H][W];

        for (int r = 0; r < H; r++) {
            String str = br.readLine();
            for (int c = 0; c < W; c++) {
                char cur = str.charAt(c);
                if (cur == 'X') {
                    board[r][c] = -1;
                } else if (cur == 'S') {
                    board[r][c] = 0;
                    mouse = new Mouse(r, c);
                } else if (cur == '.') {
                    board[r][c] = 0;
                } else {
                    board[r][c] = str.charAt(c) - '0';
                }
            }
        }


        bfs();


        bw.write(mouse.totalstep + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class RC {
        int r;
        int c;

        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    private static void bfs() {

        int cheeseCnt = 0;

        while (N > cheeseCnt) {

            Queue<RC> q = new LinkedList<>();
            q.offer(new RC(mouse.curr, mouse.curc));
            int[][] steps = new int[H][W];
            steps[mouse.curr][mouse.curc] = 1;

            midloop:
            while (q.size() > 0) {
                RC poll = q.poll();
                int curr = poll.r;
                int curc = poll.c;
                int curstep = steps[poll.r][poll.c];

                for (int d = 0; d < 4; d++) {
                    int nr = curr + dr[d];
                    int nc = curc + dc[d];

                    if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                        if (steps[nr][nc] == 0 && board[nr][nc] > 0) {
                            if (board[nr][nc] <= mouse.health) {
                                mouse.totalstep += curstep;
                                mouse.health++;
                                mouse.curr = nr;
                                mouse.curc = nc;
                                board[nr][nc] = 0;
                                cheeseCnt++;
                                break midloop;
                            } else {
                                steps[nr][nc] = curstep + 1;
                                q.offer(new RC(nr, nc));
                            }
                        } else if (steps[nr][nc] == 0 && board[nr][nc] == 0) {
                            steps[nr][nc] = curstep + 1;
                            q.offer(new RC(nr, nc));
                        }
                    }
                }

            }

        }

    }

}