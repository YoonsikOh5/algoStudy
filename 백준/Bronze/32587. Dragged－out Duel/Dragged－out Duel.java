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
        String a = br.readLine();
        String b = br.readLine();

        int acnt = 0;
        int bcnt = 0;
        for(int i = 0; i < N; i++){
            char ac = a.charAt(i);
            char bc = b.charAt(i);
            if(ac =='R' && bc == 'S'){
                acnt++;
            }
            if(ac =='R' && bc == 'P'){
                bcnt++;
            }
            if(ac =='S' && bc == 'P'){
                acnt++;
            }
            if(ac =='S' && bc == 'R'){
                bcnt++;
            }
            if(ac =='P' && bc == 'R'){
                acnt++;
            }
            if(ac =='P' && bc == 'S'){
                bcnt++;
            }

        }
        if(acnt > bcnt){
            bw.write("victory");
        } else {
            bw.write("defeat");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
