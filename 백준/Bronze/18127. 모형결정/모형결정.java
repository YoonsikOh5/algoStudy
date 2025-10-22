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

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long res = 1;
        long add = 0;
        if(A == 3){
            add = 2;
            while (B-- > 0){
                res += add;
                add++;
            }
        } else {
            add = A-1;
            while (B-- > 0){
                res += add;
                add+=A-2;
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
