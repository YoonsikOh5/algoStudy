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

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            if(a==0 && b==0 && c==0 && d==0){
                break;
            }

            if(a==0){
                a = d/(b*c);
            }
            if(b==0){
                b = d/(a*c);
            }
            if(c==0){
                c = d/(a*b);
            }
            if(d==0){
                d = a*b*c;
            }
            bw.write(a+" "+b+" "+c+" "+d+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
