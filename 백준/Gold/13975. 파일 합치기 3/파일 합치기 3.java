import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i = 0; i < K ;i++){
                pq.offer(Long.parseLong(st.nextToken()));
            }
            while (pq.size()>1){
                Long pollA = pq.poll();
                Long pollB = pq.poll();
                long midSum = pollA + pollB;
                sum += midSum;
                pq.offer(midSum);
            }
            bw.write(sum+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}