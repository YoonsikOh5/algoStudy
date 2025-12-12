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
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (!(cur == 'I' || cur == 'O' || cur == 'S' || cur == 'H' || cur == 'Z' || cur == 'X' || cur == 'N')) {
                isT = false;
                break;
            }
        }
        if (isT) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
