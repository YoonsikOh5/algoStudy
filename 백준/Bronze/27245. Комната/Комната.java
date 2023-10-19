import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int w = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());
        int h = Integer.parseInt(br.readLine());

        int sm = 0;
        int lg = 0;
        if (w <= l) {
            sm = w;
            lg = l;
        } else {
            sm = l;
            lg = l;
        }

        boolean isGood = true;

        if (sm / h < 2) {
            isGood = false;
        }
        if (lg / sm > 2) {
            isGood = false;
        }
        if (isGood) {
            bw.write("good");
        } else {
            bw.write("bad");
        }
        bw.flush();
        bw.close();
        br.close();

    }

}