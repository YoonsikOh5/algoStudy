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

        String a = "";

        while ((a = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(a);

            ArrayList<Integer> al = new ArrayList<>();
            while (st.hasMoreTokens()) {
                int cur = Integer.parseInt(st.nextToken());
                al.add(cur);
            }

            int size = al.size();
            for (int i = 0; i < size; i++) {
                int bef = i - 1;
                int cur = i;
                int next = i + 1;

                if (bef < 0 && next >= size) {
                    bw.write(al.get(cur) + " ");
                } else if (next >= size) {
                    int res = al.get(cur) * al.get(bef);
                    bw.write(res + " ");
                } else if (bef < 0) {
                    int res = al.get(cur) * al.get(next);
                    bw.write(res + " ");
                } else {
                    int res = al.get(cur) * al.get(next) * al.get(bef);
                    bw.write(res + " ");
                }
            }
            bw.write("\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

}
