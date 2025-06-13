import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        for(int i = 1; i <= N; i++){
            sum += i*(i+1);
            for(int j = 1; j <= i; j++){
                sum += j;
            }
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
