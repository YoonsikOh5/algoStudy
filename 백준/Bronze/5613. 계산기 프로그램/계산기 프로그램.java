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
        long a = Long.parseLong(br.readLine());
        String cur = br.readLine();

        while (true){
            long b = Long.parseLong(br.readLine());
            if(cur.equals("+")){
                a += b;
            } else if(cur.equals("-")){
                a -= b;
            } else if(cur.equals("*")){
                a *= b;
            } else if(cur.equals("/")){
                a /= b;
            }
            cur = br.readLine();
            if(cur.equals("=")){
                break;
            }
        }

        bw.write(a+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
