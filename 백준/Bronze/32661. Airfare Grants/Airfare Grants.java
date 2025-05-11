import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i  < N; i++){
            int cur = Integer.parseInt(br.readLine());
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }

        int ret = max / 2;
        int realret = Math.min(ret, min);

        bw.write((min-realret)+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
