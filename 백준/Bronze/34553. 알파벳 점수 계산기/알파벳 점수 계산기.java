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

        String s = br.readLine();

        int len = s.length();

        char bef = s.charAt(0);
        int cc = 1;
        int res = 0;
        res += cc;
        for(int i = 1; i < len; i++){
            char cur = s.charAt(i);
            int bi = bef - 'a';
            int ci = cur - 'a';
            if(bi < ci){
                cc++;
                res += cc;
            } else {
                cc = 1;
                res += cc;
            }
            bef = cur;
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
