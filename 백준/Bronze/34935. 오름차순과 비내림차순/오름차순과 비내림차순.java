import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long bef = Long.parseLong(st.nextToken());
        boolean isT = true;
        for (int i = 1; i < N; i++) {
            long cur = Long.parseLong(st.nextToken());
            if (cur == bef) {
                isT = false;
                break;
            }
            bef = cur;
        }
        if (isT) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
