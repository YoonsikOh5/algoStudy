import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (N >= 3 && M <= 4) {
            bw.write("TroyMartian\n");
        }
        if (N <= 6 && M >= 2) {
            bw.write("VladSaturnian\n");
        }
        if (N <= 2 && M <= 3) {
            bw.write("GraemeMercurian");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}