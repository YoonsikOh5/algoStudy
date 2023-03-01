import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static final long MODER = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
//            long result = 1;
            BigInteger result = new BigInteger("1");
            while (pq.size() > 1) {
                Long polled1 = pq.poll();
                Long polled2 = pq.poll();
                long result1 = polled1 * polled2;
                result = result.multiply(BigInteger.valueOf(result1));
                pq.offer(result1);
            }
            result = result.mod(BigInteger.valueOf(MODER));
            bw.write(result.toString() + "\n");

        }

        bw.flush();
        bw.close();
        br.close();

    }

}
