import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String cur = st.nextToken();

        int idx = 1;
        for (int i = 0; i < N; i++) {
            char c = cur.charAt(i);
            char res = (char) (((c - 'A' + idx) % 26) + 'A');
            bw.write(res + "");
            idx *= 2;
            idx %= 26;
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
