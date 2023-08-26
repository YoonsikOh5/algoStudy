import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    static int N;
    static boolean[][] visited;
    // 8방 탐색 위위 부터 시계
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            /////////////////////////////////////////////////////////////////////////////////////////////
            N = Integer.parseInt(br.readLine());
            char[][] cBoard = new char[N][N];
            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < N; c++) {
                    cBoard[r][c] = str.charAt(c);
                }
            }

            int[][] board = new int[N][N];
            visited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (cBoard[r][c] == '*') {
                        board[r][c] = -1;
                        visited[r][c] = true;
                    } else if (cBoard[r][c] == '.') {
                        int popCnt = 0;
                        for (int d = 0; d < 8; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (inRange(nr, nc)) {
                                if (cBoard[nr][nc] == '*') {
                                    popCnt++;
                                }
                            }
                        }
                        board[r][c] = popCnt;
                    }
                }
            }

            int result = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (visited[r][c] == false && board[r][c]==0) {
                        result++;
                        bfs(r, c, board);
                    }
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (visited[r][c] == false) {
                        result++;
                        visited[r][c] = true;
                    }
                }
            }

            bw.write("#" + test_case + " " + result + "\n");
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class RC {
        int R;
        int C;

        public RC(int r, int c) {
            R = r;
            C = c;
        }
    }

    private static void bfs(int r, int c, int[][] board) {
        Queue<RC> q = new LinkedList<>();
        q.offer(new RC(r, c));
        visited[r][c] = true;

        while (q.size() > 0) {
            RC poll = q.poll();

            int curr = poll.R;
            int curc = poll.C;

            for (int d = 0; d < 8; d++) {
                int nr = curr + dr[d];
                int nc = curc + dc[d];
                if (inRange(nr, nc) && visited[nr][nc] == false) {
                    visited[nr][nc] = true;
                    if (board[nr][nc] == 0) {
                        q.offer(new RC(nr, nc));
                    }
                }
            }

        }

    }

    private static boolean inRange(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            return true;
        } else {
            return false;
        }
    }


}