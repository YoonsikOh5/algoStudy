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
        String s = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        int res = 0;
        if(s.equals("residential")){
            if(n >= 16){
                res = 4;
            } else if(n >= 11){
                res = 3;
            } else if(n >= 6){
                res = 2;
            } else if(n >= 2){
                res = 1;
            }
        } else if(s.equals("commercial")){
            if(n >= 15){
                res = 3;
            } else if(n >= 8){
                res = 2;
            } else if(n >= 2){
                res = 1;
            }
        } else if(s.equals("industrial")){
            if(n >= 17){
                res = 5;
            } else if(n >= 13){
                res = 4;
            } else if(n >= 9){
                res = 3;
            } else if(n >= 5){
                res = 2;
            } else if(n >= 2){
                res = 1;
            }
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
