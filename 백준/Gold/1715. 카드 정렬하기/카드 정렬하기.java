import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue();

        for(int i = 1; i <= N; i++){
            pq.offer(Long.parseLong(br.readLine()));
        }

        long sum = 0;
        while (pq.size()>0){
            long a = pq.poll();
            if(pq.size()==0){
                break;
            }
            long b = pq.poll();
            sum += a+b;
            pq.offer(a+b);
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

}