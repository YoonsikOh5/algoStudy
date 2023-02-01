import java.io.*;
import java.util.*;


public class Main {

    static int R, C;

    static char[][] board;
    static boolean [][] visited;
    static RC start;
    static RC end;

    static int result = 0;
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

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];


        for(int r = 0; r < R; r++){
            String str = br.readLine();
            for(int c = 0; c < C; c++){
                char cur = str.charAt(c);
                if(cur=='D'){
                    end = new RC(r,c);
                } else if(cur=='S'){
                    start = new RC(r,c);
                }
                board[r][c] = cur;
            }
        }

        bfs();

        if(result!=0){
            bw.write(result+"");
        } else {
            bw.write("KAKTUS");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    // 상 하 좌 우
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};

    private static void bfs() {

        Queue<RC> q = new LinkedList<>();

        RC tcounter = new RC(-1,-1);

        q.offer(start);
        q.offer(tcounter);

        nextwater();
        visited = new boolean[R][C];
        visited[start.r][start.c] = true;


        int time = 1;

        while(q.size()>0){

            RC cur = q.poll();

            int curr = cur.r;
            int curc = cur.c;

            if(curr==-1 && curc==-1){
                if(q.size()>0){
                    time++;
                    q.offer(tcounter);
                    nextwater();
                } else {
                    break;
                }
            }

            for(int d = 0; d < 4; d++){
                int nr = curr + dr[d];
                int nc = curc + dc[d];

                if(inRange(nr,nc)){
                    if(board[nr][nc]=='.' && visited[nr][nc]==false){
                        visited[nr][nc] = true;
                        q.offer(new RC(nr,nc));
                    } else if(nr==end.r && nc==end.c){
                        result = time;
                        return;
                    }
                }

            }

        }


    }

    private static void nextwater() {
        char[][] nextboard = new char[R][C];
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                nextboard[r][c] = board[r][c];
            }
        }
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(board[r][c]=='*'){
                    for(int d = 0; d < 4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(inRange(nr,nc)){
                            if(nextboard[nr][nc]=='.' || nextboard[nr][nc]=='S'){
                                nextboard[nr][nc] = '*';
                            }
                        }
                    }
                }
            }
        }


        board = nextboard;
    }

    private static boolean inRange(int nr, int nc) {
        if(nr>=0 && nr < R && nc>=0 && nc <C){
            return true;
        } else{
            return false;
        }
    }

}
