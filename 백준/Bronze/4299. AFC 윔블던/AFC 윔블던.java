import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());

        int a = (sum + minus) / 2;
        int b = sum - a;
        if ((a + b) == sum && (a - b) == minus && a >= 0 && b >= 0) {
            bw.write(a + " " + b);
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
