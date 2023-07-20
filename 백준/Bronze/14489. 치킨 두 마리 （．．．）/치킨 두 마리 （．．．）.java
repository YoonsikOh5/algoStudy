import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(br.readLine());

        if (a + b >= 2*c) {
            bw.write(a + b - (c * 2) + "");

        } else {
            bw.write(a + b + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}