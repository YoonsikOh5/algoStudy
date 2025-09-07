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
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a >= 0) {
                if (b >= 0) {
                    if (b >= a) {
                        if (c >= 0) {
                            if(c >= b){
                                res++;
                            }
                        } else {
                            res++;
                        }
                    }
                } else {
                    if(c < 0){
                        res++;
                    }
                }
            }
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
