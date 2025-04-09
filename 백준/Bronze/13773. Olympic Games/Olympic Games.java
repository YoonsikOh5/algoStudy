import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cur = Integer.parseInt(br.readLine());
        while (cur != 0){

            if(cur < 1896){
                bw.write(cur+" No summer games\n");
            } else {
                if((cur-1896)%4==0){
                    if(cur > 2020){
                        bw.write(cur+" No city yet chosen\n");
                    } else if((cur >= 1914 && cur <= 1918) || (cur >= 1939 && cur <= 1945)){
                        bw.write(cur+" Games cancelled\n");
                    } else {
                        bw.write(cur+" Summer Olympics\n");
                    }
                } else {
                    bw.write(cur+" No summer games\n");
                }
            }

            cur = Integer.parseInt(br.readLine());
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
