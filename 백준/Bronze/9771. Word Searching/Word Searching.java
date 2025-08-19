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

        String tgt = br.readLine();
        String str = "";
        int count = 0;

        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            while (st.hasMoreTokens()) {

                String cur = st.nextToken();
                int index = -1;
                while ((index = cur.indexOf(tgt, index + 1)) != -1) {
                    count++;
                }


            }
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
