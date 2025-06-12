import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(br.readLine());

        int upper = start;
        int upcnt = 0;
        int lower = start;
        int locnt = 0;
        while (true){
            if(upper % 100 == 99){
                break;
            }
            upcnt++;
            upper++;
        }

        while (lower > 0){
            if(lower % 100 == 99){
                break;
            }
            locnt++;
            lower--;
        }

        if(lower == 0){
            bw.write(upper+"");
        } else {
            if(upcnt <= locnt){
                bw.write(upper+"");
            } else {
                bw.write(lower+"");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
