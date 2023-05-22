import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (b < n) {
            bw.write("Bus");
        } else if (a < b) {
            bw.write("Bus");
        } else if (a == b) {
            bw.write("Anything");
        } else if (a > b) {
            bw.write("Subway");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}
