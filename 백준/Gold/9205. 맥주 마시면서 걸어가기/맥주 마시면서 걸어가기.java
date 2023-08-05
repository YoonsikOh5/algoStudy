import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isAbleToReach(XY target){
            int dist = Math.abs(this.x - target.x) + Math.abs(this.y - target.y);
            if(dist <= 1000){
                return true;
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            XY[] carr = new XY[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hx = Integer.parseInt(st.nextToken());
            int hy = Integer.parseInt(st.nextToken());
            XY home = new XY(hx,hy);
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                carr[j] = new XY(cx,cy);
            }
            st = new StringTokenizer(br.readLine());
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());
            XY penta = new XY(px, py);


            Queue<XY> q = new LinkedList<>();
            q.offer(home);
            boolean[] visited = new boolean[n];
            boolean isAble = false;
            while (q.size()>0){
                XY poll = q.poll();
                int cx = poll.x;
                int cy = poll.y;
                // penta 갈 수 있는지 바로 확인
                if(poll.isAbleToReach(penta)){
                    isAble = true;
                    break;
                }
                for(int c = 0; c < n; c++){
                    if(!visited[c] && poll.isAbleToReach(carr[c])){
                        visited[c] = true;
                        q.offer(carr[c]);
                    }
                }
            }
            if(isAble){
                bw.write("happy\n");
            } else {
                bw.write("sad\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }


}