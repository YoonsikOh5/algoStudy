import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;
    static int[][] iBoard;
//    static RCGN[][] dijkBoard;

    static RC start, finish;
    static RCGN end;

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // G 쓰레기 닿은 횟수 // N 옆에 지나간 횟수
    static class RCGN implements Comparable<RCGN> {

        int R;
        int C;
        int G;
        int N;

        public RCGN(int r, int c, int g, int n) {
            R = r;
            C = c;
            G = g;
            N = n;
        }

        @Override
        public int compareTo(RCGN o) {
            if (this.G == o.G) {
                return this.N - o.N;
            }
            return this.G - o.G;
        }
    }

    static class RC {
        int R;
        int C;

        public RC(int r, int c) {
            R = r;
            C = c;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        iBoard = new int[N][M];
//        dijkBoard = new RCGN[N][M];
        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < M; c++) {
                board[r][c] = s.charAt(c);
                if (board[r][c] == 'S') {
                    start = new RC(r, c);
                }
                if (board[r][c] == 'F') {
                    finish = new RC(r, c);
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c] == 'g') {
                    // 쓰레기 칸은 -1
                    iBoard[r][c] = -1;
                } else {
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                            if (board[nr][nc] == 'g') {
                                // 쓰레기 옆칸은 1
                                iBoard[r][c] = 1;
                                break;
                            }
                        }
                    }
                }
            }
        }

//        for (int r = 0; r < N; r++) {
//            for (int c = 0; c < M; c++) {
//                dijkBoard[r][c] = new RCGN(r, c, Integer.MAX_VALUE, Integer.MAX_VALUE);
//            }
//        }

        doDijk();

        bw.write(end.G + " " + end.N);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void doDijk() {
        boolean[][] visited = new boolean[N][M];

        RCGN startRCGN = new RCGN(start.R, start.C, 0, 0);

//        dijkBoard[start.R][start.C] = startRCGN;

        PriorityQueue<RCGN> pq = new PriorityQueue<>();

        pq.offer(startRCGN);

        outloop:
        while (pq.size() > 0) {
            RCGN poll = pq.poll();
            int r = poll.R;
            int c = poll.C;
            int g = poll.G;
            int n = poll.N;
            if (visited[r][c] == true) {
                continue;
            }
            visited[r][c] = true;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] == false) {
                    RCGN rcgn = null;
                    if (nr == finish.R && nc == finish.C) {
                        end = new RCGN(r, c, g, n);
                        break outloop;
                    }
                    if (iBoard[nr][nc] == -1) {
                        rcgn = new RCGN(nr, nc, g + 1, n);
                    } else if (iBoard[nr][nc] == 1) {
                        rcgn = new RCGN(nr, nc, g, n + 1);
                    } else {
                        rcgn = new RCGN(nr, nc, g, n);
                    }
//                    System.out.println(rcgn.R + " " + rcgn.C + " " + rcgn.G + " " + rcgn.N);
//                    dijkBoard[nr][nc] = rcgn;
                    pq.offer(rcgn);
                }
            }
        }
    }
}