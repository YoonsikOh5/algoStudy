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
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        for (int r = 1; r <= P; r++) {
            if (P % r == 0) {
                for (int c = 1; c <= Q; c++) {
                    if(Q % c == 0){
                        bw.write(r+" "+c+"\n");
                    }
                }
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
