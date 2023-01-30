import java.io.*;
import java.util.*;


// 제출전에 Main으로 바꾸는거 잊지말기!
public class Main {

    static int N;
    static int[][] board;

    // 0,1,2,3 왼 아 오 위
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};

    // 7퍼센트 왼 오는 0,2 // 아 위는 1,3으로
    static int[] d7r = {1,0,-1,0};
    static int[] d7c = {0,1,0,-1};

    // 2퍼센트 왼 오는 0,2 // 아 위는 1,3으로
    static int[] d2r = {2,0,-2,0};
    static int[] d2c = {0,2,0,-2};

    // 5퍼센트 왼,아,오,위
    static int[] d5r = {0,2,0,-2};
    static int[] d5c = {-2,0,2,0};

    // 10퍼센트 왼,아,오,위 두개씩
    static int[] d10r = {-1,1,1,-1};
    static int[] d10c = {-1,-1,1,1};

    // 1퍼센트 왼,아,오,위 두개씩
    static int[] d1r = {1,-1,-1,1};
    static int[] d1c = {1,1,-1,-1};

    static class Tornado {

        int curr;
        int curc;
        // 0,1,2,3 -> 왼 아 오 위
        int curdirection;
        boolean isTornadoOut;

        public Tornado(int curr, int curc, int curdirection) {
            this.curr = curr;
            this.curc = curc;
            this.curdirection = curdirection;
            this.isTornadoOut = false;
        }

        void tonadoturn(){
            this.curdirection = (this.curdirection+1)%4;
        }

        int move() {
            int nextr = curr + dr[curdirection];
            int nextc = curc + dc[curdirection];

            int initialSand = board[nextr][nextc];

            int outsand = 0;
            int movedsand = 0;

            // 여기서 토네이도 방향 + 범위 만큼 모래 뿌려줌
            int onePercent = (int) (initialSand * 0.01);
            int twoPercent = (int) (initialSand * 0.02);
            int fivePercent = (int) (initialSand * 0.05);
            int sevenPercent = (int) (initialSand * 0.07);
            int tenPercent = (int) (initialSand * 0.1);

            for(int i = 0; i < 2; i++){
                int nd = (curdirection + (i*2))%4;

                int n7r = nextr+d7r[nd];
                int n7c = nextc+d7c[nd];

                if(inRange(n7r,n7c)){
                    board[n7r][n7c] += sevenPercent;
                    movedsand += sevenPercent;
                } else {
                    outsand += sevenPercent;
                }
            }

            for(int i = 0; i < 2; i++){
                int nd = (curdirection + (i*2))%4;

                int n2r = nextr+d2r[nd];
                int n2c = nextc+d2c[nd];

                if(inRange(n2r,n2c)){
                    board[n2r][n2c] += twoPercent;
                    movedsand += twoPercent;
                } else {
                    outsand += twoPercent;
                }
            }


            int n5r = nextr+d5r[curdirection];
            int n5c = nextc+d5c[curdirection];

            if(inRange(n5r,n5c)){
                board[n5r][n5c] += fivePercent;
                movedsand += fivePercent;
            } else {
                outsand += fivePercent;
            }

            for(int i = 0; i < 2; i++){
                int nd = (curdirection + i)%4;

                int n10r = nextr+d10r[nd];
                int n10c = nextc+d10c[nd];

                if(inRange(n10r,n10c)){
                    board[n10r][n10c] += tenPercent;
                    movedsand += tenPercent;
                } else {
                    outsand += tenPercent;
                }
            }

            for(int i = 0; i < 2; i++){
                int nd = (curdirection + i)%4;

                int n1r = nextr+d1r[nd];
                int n1c = nextc+d1c[nd];

                if(inRange(n1r,n1c)){
                    board[n1r][n1c] += onePercent;
                    movedsand += onePercent;
                } else {
                    outsand += onePercent;
                }
            }

            // 다 뿌리고 남은 모래를 마지막에 앞쪽으로
            int nar = nextr+dr[curdirection];
            int nac = nextc+dc[curdirection];

            int remainsand = (initialSand - movedsand - outsand);

            if(inRange(nar,nac)){
                board[nar][nac] += remainsand;
            } else{
                outsand += remainsand;
            }

            if(nextr==0 && nextc==0){
                isTornadoOut = true;
            }

            this.curr = nextr;
            this.curc = nextc;

            // 범위 밖으로 나간 모래들 리턴해주기
            return outsand;
        }


    }
    private static boolean inRange(int nr, int nc) {
        if(nr>=0 && nr < N && nc>=0 && nc < N){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int r = 0; r < N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++){
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int startr = N/2;
        int startc = N/2;

        Tornado tornado = new Tornado(startr,startc,0);

        int result = 0;

        int movecount = 0;
        int maxmovecount = 1;
        int countupflag = 0;
        while (!tornado.isTornadoOut){

            if(movecount < maxmovecount){
                result += tornado.move();
                movecount++;
            } else if(countupflag==1){
                tornado.tonadoturn();
                movecount=0;
                countupflag=0;
                maxmovecount++;
            } else if (countupflag==0) {
                tornado.tonadoturn();
                movecount=0;
                countupflag++;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }




}
