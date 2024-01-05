import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int d = 0;
        int f = 0;

        if (a == 1) {
            d++;
        } else {
            f++;
        }

        if (b == 1) {
            d++;
        } else {
            f++;
        }

        if (c == 1) {
            d++;
        } else {
            f++;
        }

        if (d > f) {
            bw.write("1");
        } else {
            bw.write("2");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}