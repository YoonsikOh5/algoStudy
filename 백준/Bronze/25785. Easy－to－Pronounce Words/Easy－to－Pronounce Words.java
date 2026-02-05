import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();

        boolean isT = true;
        int bef = 0;
        char cur = s.charAt(0);
        if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
            bef = 1;
        }
        for (int i = 1; i < len; i++) {
            cur = s.charAt(i);
            if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                if (bef == 1) {
                    isT = false;
                    break;
                } else {
                    bef = 1;
                }
            } else {
                if (bef == 0) {
                    isT = false;
                    break;
                } else {
                    bef = 0;
                }
            }
        }
        if (isT) {
            bw.write( "1");
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
