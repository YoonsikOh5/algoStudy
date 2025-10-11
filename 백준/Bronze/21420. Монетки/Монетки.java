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

        int ocnt = 0;
        int zcnt = 0;
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur == 1){
                ocnt++;
            } else if(cur == 0){
                zcnt++;
            }
        }
        int res = Math.min(ocnt,zcnt);
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
