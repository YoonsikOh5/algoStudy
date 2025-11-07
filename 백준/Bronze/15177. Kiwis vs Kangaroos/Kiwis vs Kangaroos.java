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
        String kan = "KANGAROO";
        String kiw = "KIWIBIRD";
        int kac = 0;
        int kic = 0;

        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            char c1 = Character.toUpperCase(cur);

            for(int j = 0; j < 8; j++){
                char c = kan.charAt(j);
                char ki = kiw.charAt(j);
                if(c == c1){
                    kac++;
                }
                if(ki == c1){
                    kic++;
                }
            }
        }

        if(kac > kic){
            bw.write("Kangaroos");
        } else if(kac < kic){
            bw.write("Kiwis");
        } else {
            bw.write("Feud continues");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
