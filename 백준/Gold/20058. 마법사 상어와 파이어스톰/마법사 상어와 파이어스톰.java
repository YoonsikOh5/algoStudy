import java.io.*;
import java.util.*;


public class Main {

    static int N;
    static int len;
    static int Q;
    static int[][] board;
    static int[][] nextboard;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        double pow = Math.pow(2, N);
        len = (int) pow;
        board = new int[len][len];
        for (int r = 0; r < len; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < len; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int curcmd = Integer.parseInt(st.nextToken());

            rotate(curcmd);

            meltice();

        }

        // 합 구하고
        int resultsum = 0;

        for (int[] ints : board) {
            for (int anInt : ints) {
                resultsum += anInt;
            }
        }

        visited = new boolean[len][len];
        int maxice = 0;
        // 덩어리 구하고
        for(int r = 0; r < len; r++){
            for(int c = 0; c < len; c++){
                if(visited[r][c]==false && board[r][c]>0){
                    maxice = Math.max(bfs(r,c),maxice);
                }
            }
        }


        bw.write(resultsum+"\n"+maxice);
        bw.flush();
        bw.close();
        br.close();

    }

    static class RC{
        int r;
        int c;

        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int bfs(int r, int c) {
        int icecnt = 0;
        Queue<RC> q = new LinkedList<>();
        q.offer(new RC(r,c));
        visited[r][c] = true;
        while (q.size()>0){
            RC poll = q.poll();
            icecnt++;
            int curr = poll.r;
            int curc = poll.c;

            for(int d = 0; d < 4; d++){
                int nr = curr+dr[d];
                int nc = curc+dc[d];
                if(inRange(nr,nc) && visited[nr][nc]==false && board[nr][nc]>0){
                    visited[nr][nc] = true;
                    q.offer(new RC(nr,nc));
                }
            }
        }
        return icecnt;
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    private static void meltice() {
        nextboard = new int[len][len];
        for(int r = 0; r < len; r++){
            for(int c = 0; c < len; c++){
                int noicecount = 0;
                for(int d = 0; d < 4; d++){
                    int nr = r+ dr[d];
                    int nc = c+ dc[d];
                    if(inRange(nr,nc)){
                        if(board[nr][nc]==0){
                            noicecount++;
                        }
                    } else{
                        noicecount++;
                    }
                }
                if(noicecount>=2 && board[r][c]>0){
                    nextboard[r][c] = board[r][c]-1;
                } else{
                    nextboard[r][c] = board[r][c];
                }
            }
        }
        board=nextboard;
    }

    private static boolean inRange(int nr, int nc) {
        if(nr>=0 && nr<len && nc>=0 && nc<len){
            return true;
        } else{
            return false;
        }
    }

    private static void rotate(int curcmd) {
        if (curcmd == 0) {
            return;
        }
        nextboard = new int[len][len];
        double pow = Math.pow(2, curcmd);
        int point = (int) pow;
        for (int r = 0; r < len; r += point) {
            for (int c = 0; c < len; c += point) {
                startpointrotate(r, c, point);
            }
        }
        board = nextboard;
    }

    private static void startpointrotate(int r, int c, int point) {
        
        int rlen = r + point;
        int clen = c + point;
        int rcount = 0;
        for(int nr = r; nr < rlen; nr++){
            int ccount = 0;
            for(int nc = c; nc < clen; nc++){
                nextboard[r+ccount][clen-1-rcount] = board[nr][nc];
                ccount++;
            }
            rcount++;
        }

    }


}
