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

        String dir = "right";
        while(true){
            String s = br.readLine();
            if(s.equals("99999")){
                break;
            }
            char c1 = s.charAt(0);
            int a1 = c1 - '0';
            char c2 = s.charAt(1);
            int a2 = c2 - '0';
            if((a1+a2)==0){
                dir = dir;
            } else if((a1+a2)%2==0){
                dir = "right";
            } else if((a1+a2)%2==1){
                dir = "left";
            }

            bw.write(dir+" "+s.substring(2)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
