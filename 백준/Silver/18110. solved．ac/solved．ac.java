import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        if (n == 0) {
            bw.write("0");
        } else {
            double remove = n * (0.15);
            int ceilNum = (int) Math.round(remove);
            for(int i = 1; i <= ceilNum; i++){
                pq.poll();
            }
            int an = n - (ceilNum * 2);
            int sum = 0;
            for(int i = 1; i <= an; i++){
                sum += pq.poll();
            }
            double resultdouble = (double) sum / (double) an;
            int result = (int) Math.round(resultdouble);
            bw.write(result+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}