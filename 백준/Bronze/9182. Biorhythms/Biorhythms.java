import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int CYCLE = 21252;
        int caseNo = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (p == -1 && e == -1 && i == -1 && d == -1) {
                break;
            }

            int x = (5544 * p + 14421 * e + 1288 * i) % CYCLE;
            int days = x - d;
            if (days <= 0) {
                days += CYCLE;
            }

            bw.write("Case " + caseNo + ": the next triple peak occurs in " + days + " days.");
            bw.newLine();
            caseNo++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
