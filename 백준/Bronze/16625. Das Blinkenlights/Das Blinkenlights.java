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

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        boolean isT = false;
        for(int i = 1; i <= s; i++){
            if(i%p == 0 && i%q == 0){
                isT = true;
            }
        }

        if(isT){
            bw.write("yes");
        } else {
            bw.write("no");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
