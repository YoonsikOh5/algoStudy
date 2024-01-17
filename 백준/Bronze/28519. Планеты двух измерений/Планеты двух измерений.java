import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a == b) {
            bw.write(a * 2 + "");
        } else if (a < b) {
            bw.write((a * 2 + 1) + "");
        } else if (a > b) {
            bw.write((b * 2 + 1) + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}