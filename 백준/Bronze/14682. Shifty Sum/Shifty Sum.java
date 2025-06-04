import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long sum = N;

        for(int i = 1; i <= k; i++){
            N *= 10;
            sum += N;
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
