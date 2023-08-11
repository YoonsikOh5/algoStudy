import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int minresult;
    static Hide resultHide;

    static class Hide {
        Hide before;
        int cur;

        public Hide(int cur) {
            this.cur = cur;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        bw.write(minresult+"\n");
        Hide resultHide1 = resultHide;
        Stack<Integer> stack = new Stack<>();
        stack.push(resultHide1.cur);
        while (resultHide1.before!=null){
            resultHide1 = resultHide1.before;
            stack.push(resultHide1.cur);
        }
        while (stack.size()>0){
            bw.write(stack.pop()+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        boolean[] visited = new boolean[100001];
        int cur = N;
        Queue<Hide> q = new LinkedList<>();
        Hide hide = new Hide(cur);
        q.offer(hide);
        Hide checker = new Hide(-1);
        visited[N] = true;
        q.offer(checker);
        int seconds = 0;
        boolean findResult = false;
        while (q.size()>0){
            Hide polled = q.poll();
            int poll = polled.cur;
            if(poll==-1){
                if(findResult) break;
                seconds++;
                q.offer(checker);
                continue;
            }
            if(poll == K){
                findResult=true;
                minresult = seconds;
                resultHide = polled;
                break;
            }
            int pminus1 = poll-1;
            int pplus1 = poll+1;
            int pmulti2 = poll*2;
            if(pminus1>=0 && pminus1<=100000 && visited[pminus1]==false){
                Hide hide1 = new Hide(pminus1);
                hide1.before = polled;
                visited[pminus1] = true;
                q.offer(hide1);
            }
            if(pplus1>=0 && pplus1<=100000 && visited[pplus1]==false){
                Hide hide1 = new Hide(pplus1);
                hide1.before = polled;
                visited[pplus1] = true;
                q.offer(hide1);
            }
            if(pmulti2>=0 && pmulti2<=100000 && visited[pmulti2]==false){
                Hide hide1 = new Hide(pmulti2);
                hide1.before = polled;
                visited[pmulti2] = true;
                q.offer(hide1);
            }
        }
    }

}