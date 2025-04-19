import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long l = Long.parseLong(br.readLine());
        long cur = l;
        while (true){
            long curSum = 0;
            long temp = cur;
            while (temp > 0) {
                curSum += (temp % 10);
                temp /= 10;
            }

            if(cur % curSum == 0) {
                bw.write(cur + "");
                break;
            }
            cur++;
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
