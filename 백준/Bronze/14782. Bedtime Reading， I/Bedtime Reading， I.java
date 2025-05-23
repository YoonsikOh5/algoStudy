import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long res = 0;

        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                res += i;
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
