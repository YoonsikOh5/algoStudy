import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {

    static int[][] part;
    static int[][] board;

    private static final long EXPONENT1 = 31;
    private static final long EXPONENT2 = 37;
    private static final long EXPONENT3 = 41;
    private static final long EXPONENT4 = 43;
    private static final long EXPONENT5 = 47;
    private static final long EXPONENT6 = 53;

    static int H, W, N, M;

    static long partHash1;
    static long partHash2;
    static long partHash3;

    static long result;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            part = new int[H][W];
            board = new int[N][M];

            for (int r = 0; r < H; r++) {
                String str = br.readLine();
                for (int c = 0; c < W; c++) {
                    if (str.charAt(c) == 'o') {
                        part[r][c] = 1;
                    } else if (str.charAt(c) == 'x') {
                        part[r][c] = 0;
                    }

                }
            }

            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < M; c++) {
                    if (str.charAt(c) == 'o') {
                        board[r][c] = 1;
                    } else if (str.charAt(c) == 'x') {
                        board[r][c] = 0;
                    }
                }
            }

            doPartHash();

            result = 0;
            doBoardHash();

            bw.write("#" + tc + " " + result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static void doBoardHash() {
        long[][][] boardRowHash = new long[N][M][3];

        int colL = M - W;
        for (int r = 0; r < N; r++) {
            long totalHash1 = 0;
            long power1 = 1;
            long totalHash2 = 0;
            long power2 = 1;
            long totalHash3 = 0;
            long power3 = 1;


            for (int c = 0; c <= colL; c++) {
                if (c == 0) {
                    for (int i = 0; i < W; i++) {
                        totalHash1 += hash(board[r][W - 1 - i], power1);
                        totalHash2 += hash(board[r][W - 1 - i], power2);
                        totalHash3 += hash(board[r][W - 1 - i], power3);
                        if (i < W - 1) {
                            power1 *= EXPONENT1;
                            power2 *= EXPONENT2;
                            power3 *= EXPONENT3;
                        }
                        boardRowHash[r][c][0] = totalHash1;
                        boardRowHash[r][c][1] = totalHash2;
                        boardRowHash[r][c][2] = totalHash3;
                    }
                } else {
                    totalHash1 = EXPONENT1 * (totalHash1 - hash(board[r][c - 1], power1)) + board[r][W - 1 + c];
                    totalHash2 = EXPONENT2 * (totalHash2 - hash(board[r][c - 1], power2)) + board[r][W - 1 + c];
                    totalHash3 = EXPONENT3 * (totalHash3 - hash(board[r][c - 1], power3)) + board[r][W - 1 + c];

                    boardRowHash[r][c][0] = totalHash1;
                    boardRowHash[r][c][1] = totalHash2;
                    boardRowHash[r][c][2] = totalHash3;
                }
            }
        }
        int rowL = N - H;
        for (int c = 0; c <= colL; c++) {
            long totalHash1 = 0;
            long power1 = 1;
            long totalHash2 = 0;
            long power2 = 1;
            long totalHash3 = 0;
            long power3 = 1;
            for (int r = 0; r <= rowL; r++) {
                if (r == 0) {
                    for (int i = 0; i < H; i++) {
                        totalHash1 += hash(boardRowHash[H - 1 - i][c][0], power1);
                        totalHash2 += hash(boardRowHash[H - 1 - i][c][1], power2);
                        totalHash3 += hash(boardRowHash[H - 1 - i][c][2], power3);
                        if (i < H - 1) {
                            power1 *= EXPONENT4;
                            power2 *= EXPONENT5;
                            power3 *= EXPONENT6;
                        }

                    }
//                    System.out.println("r,c"+r+" "+c+" 일때"+" p1 "+partHash1+" t1 "+totalHash1+" p2 "+partHash2+ " t2 "+totalHash2+" p3 "+partHash3+" t3 "+totalHash3+" p4 "+partHash4+" t4 "+totalHash4+" p4 "+partHash5+" t5 "+totalHash5 );
                    if (partHash1 == totalHash1 && partHash2 == totalHash2 && partHash3 == totalHash3) {
                        result++;
//                        System.out.println("r,c답"+r+" "+c);
                    }
                } else {
                    totalHash1 = EXPONENT4 * (totalHash1 - hash(boardRowHash[r - 1][c][0], power1)) + boardRowHash[H - 1 + r][c][0];
                    totalHash2 = EXPONENT5 * (totalHash2 - hash(boardRowHash[r - 1][c][1], power2)) + boardRowHash[H - 1 + r][c][1];
                    totalHash3 = EXPONENT6 * (totalHash3 - hash(boardRowHash[r - 1][c][2], power3)) + boardRowHash[H - 1 + r][c][2];
//                    System.out.println("r,c"+r+" "+c+" 일때"+" p1 "+partHash1+" t1 "+totalHash1+" p2 "+partHash2+" t2 "+totalHash2+" p3 "+partHash3+" t3 "+totalHash3+" p4 "+partHash4+" t4 "+totalHash4+" p4 "+partHash5+" t5 "+totalHash5 );
                    if (partHash1 == totalHash1 && partHash2 == totalHash2 && partHash3 == totalHash3) {
                        result++;
//                        System.out.println("r,c답"+r+" "+c);
                    }
                }
            }
        }

    }

    private static void doPartHash() {

        long[][][] partRowHash = new long[H][1][5];

        for (int r = 0; r < H; r++) {
            long partHash1 = 0;
            long power1 = 1;
            long partHash2 = 0;
            long power2 = 1;
            long partHash3 = 0;
            long power3 = 1;

            for (int c = 0; c < W; c++) {
                partHash1 += hash(part[r][W - 1 - c], power1);
                partHash2 += hash(part[r][W - 1 - c], power2);
                partHash3 += hash(part[r][W - 1 - c], power3);
                if (c < W - 1) {
                    power1 *= EXPONENT1;
                    power2 *= EXPONENT2;
                    power3 *= EXPONENT3;
                }
            }
            partRowHash[r][0][0] = partHash1;
            partRowHash[r][0][1] = partHash2;
            partRowHash[r][0][2] = partHash3;
        }

        partHash1 = 0;
        long power1 = 1;
        partHash2 = 0;
        long power2 = 1;
        partHash3 = 0;
        long power3 = 1;

        for (int r = 0; r < H; r++) {
            partHash1 += hash(partRowHash[H - 1 - r][0][0], power1);
            partHash2 += hash(partRowHash[H - 1 - r][0][1], power2);
            partHash3 += hash(partRowHash[H - 1 - r][0][2], power3);
            if (r < H - 1) {
                power1 *= EXPONENT4;
                power2 *= EXPONENT5;
                power3 *= EXPONENT6;
            }
        }
    }

    private static long hash(long value, long power) {
        return value * power;
    }

}