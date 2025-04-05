import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(A);
        pq.offer(B);
        pq.offer(C);
        int n1 = pq.poll();
        int n2 = pq.poll();
        int n3 = pq.poll();

        int d1 = n2 - n1;
        int d2 = n3 - n2;

        if (d1 == d2) {
            bw.write((n3 + d2) + "");
        } else if (d1 > d2) {
            bw.write((n1 + d2) + "");
        } else if (d1 < d2) {
            bw.write((n2 + d1) + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
