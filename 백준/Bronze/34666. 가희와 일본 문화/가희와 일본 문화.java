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

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (cur == 1 || cur == 2) {
                if (c >= 50) {
                    boolean isT = false;
                    int a3 = a * 3;
                    int b3 = b * 3;
                    if (cur == 1) {
                        if (a3 < 100 && b3 < 100) {
                            isT = true;
                        }
                        if(a < 22 || b < 22){
                            isT = true;
                        }
                    } else if (cur == 2) {
                        if (a3 < 90 && b3 < 90) {
                            isT = true;
                        }
                        if(a < 22 || b < 22){
                            isT = true;
                        }
                    }
                    if(isT){
                        bw.write("YES\n");
                    } else {
                        bw.write("NO\n");
                    }
                } else {
                    bw.write("NO\n");
                }
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
