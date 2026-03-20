import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] denomination = {1, 5, 10, 20, 50, 100};
        StringTokenizer st = new StringTokenizer(br.readLine());

        long bestAmount = -1;
        int bestCount = Integer.MAX_VALUE;
        int bestDenomination = denomination[0];

        for (int i = 0; i < 6; i++) {
            int count = Integer.parseInt(st.nextToken());
            long amount = (long) count * denomination[i];

            if (amount > bestAmount || (amount == bestAmount && count < bestCount)) {
                bestAmount = amount;
                bestCount = count;
                bestDenomination = denomination[i];
            }
        }

        bw.write(String.valueOf(bestDenomination));
        bw.flush();
        bw.close();
        br.close();
    }
}
