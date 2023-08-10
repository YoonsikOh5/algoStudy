import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int minresult;
    static int cntresult;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        bw.write(minresult+"\n"+cntresult);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        boolean[] visited = new boolean[100001];
        int cur = N;
        Queue<Integer> q = new LinkedList<>();
        q.offer(cur);
        q.offer(-1);
        int seconds = 0;
        boolean findResult = false;
        while (q.size()>0){
            Integer poll = q.poll();
            if(poll==-1){
                if(findResult) break;
                seconds++;
                q.offer(-1);
                continue;
            }
            visited[poll] = true;
            if(poll == K){
                findResult=true;
                minresult = seconds;
                cntresult++;
                continue;
            }
            int pminus1 = poll-1;
            int pplus1 = poll+1;
            int pmulti2 = poll*2;
            if(pminus1>=0 && pminus1<=100000 && visited[pminus1]==false){
                q.offer(pminus1);
            }
            if(pplus1>=0 && pplus1<=100000 && visited[pplus1]==false){
                q.offer(pplus1);
            }
            if(pmulti2>=0 && pmulti2<=100000 && visited[pmulti2]==false){
                q.offer(pmulti2);
            }
        }
    }

}