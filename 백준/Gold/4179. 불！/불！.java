import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int H, W;
    static char[][] building;
    static Queue<RC> q;
    static RC SangGeun;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int result;

    static class RC {
        int r;
        int c;

        int isfire;

        public RC(int r, int c, int isfire) {
            this.r = r;
            this.c = c;
            this.isfire = isfire;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            building = new char[H][W];
            q = new LinkedList<>();
            result = -1;

            SangGeun = new RC(-1,-1,0);

            for (int r = 0; r < H; r++){
                String str = br.readLine();
                for(int c = 0; c < W; c++){
                    char cur = str.charAt(c);
                    building[r][c] = cur;
                    if(cur == 'F'){
                        q.add(new RC(r,c,1));
                    } else if(cur=='J'){
                        SangGeun.r = r;
                        SangGeun.c = c;
                    }
                }
            }
            q.add(SangGeun);

            boolean isPossible = bfs();
            if(isPossible){
                bw.write(result+"\n");
            } else {
                bw.write("IMPOSSIBLE\n");
            }


        bw.flush();
        bw.close();
        br.close();

    }

    static boolean bfs() {
        int step[][] = new int[H][W];

        step[SangGeun.r][SangGeun.c] = 1;

        while(q.size()>0){
            RC cur = q.poll();

            int curr = cur.r;
            int curc = cur.c;
            int isfire = cur.isfire;

            for(int d = 0; d < 4; d++){
                int nr = curr + dr[d];
                int nc = curc + dc[d];

                if(isfire==1){
                    if(nr>=0 && nr < H && nc >= 0 && nc < W){
                        if(building[nr][nc]=='.' && step[nr][nc]==0){
                            step[nr][nc]=-1;
                            q.add(new RC(nr,nc,1));
                        }
                    }
                } else if(isfire==0){
                    if(nr>=0 && nr < H && nc >= 0 && nc < W){
                        if(building[nr][nc]=='.' && step[nr][nc]==0){
                            step[nr][nc] = (step[curr][curc]+1);
                            q.add(new RC(nr,nc, 0));
                        }
                    } else {
                        result = step[curr][curc];
                        return true;
                    }
                }
            }
        }

        return false;
    }

}