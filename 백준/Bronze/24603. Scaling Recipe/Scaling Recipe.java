import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double v = y / x;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            double res = a * v;
            long res1 = Math.round(res);
            bw.write(res1+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
