import java.io.*;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);

        Integer polla = pq.poll();
        Integer pollb = pq.poll();
        Integer pollc = pq.poll();

        bw.write(pollb+pollc+"");
        bw.flush();
        bw.close();
        br.close();
    }


}