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

        int T = Integer.parseInt(br.readLine());

        boolean isK = false;
        boolean isP = false;
        boolean isW = false;
        for(int i = 1; i <= T; i++){
            String s = br.readLine();
            if(s.equals("keys")){
                isK = true;
            }
            if(s.equals("phone")){
                isP = true;
            }
            if(s.equals("wallet")){
                isW = true;
            }
        }

        if(isK && isP && isW){
            bw.write("ready");
        } else {
            if(!isK){
                bw.write("keys\n");
            }
            if(!isP){
                bw.write("phone\n");
            }
            if(!isW){
                bw.write("wallet\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
