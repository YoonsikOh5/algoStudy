import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int div = b / 2;
        int rem = b % 2;

        if (a < div) {
            bw.write("H");
        } else if (a == div) {
            if (rem == 0) {
                bw.write("E");
            } else if (rem == 1) {
                bw.write("H");
            }
        } else {
            bw.write("E");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}