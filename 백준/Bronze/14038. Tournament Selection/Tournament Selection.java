import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int winCnt = 0;
        for (int i = 0; i < 6; i++) {
            char c = br.readLine().charAt(0);
            if (c == 'W') winCnt++;
        }
        if (winCnt == 0) {
            bw.write("-1");
        } else if (winCnt <= 2) {
            bw.write("3");
        } else if (winCnt <= 4) {
            bw.write("2");
        } else if (winCnt <= 6) {
            bw.write("1");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}