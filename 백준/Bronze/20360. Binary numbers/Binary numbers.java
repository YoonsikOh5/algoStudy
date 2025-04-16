import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while(N > 0){
            if(N % 2 == 1){
                bw.write(cnt+" ");
            }
            N /= 2;
            cnt++;
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
