import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long res = 0;

        for(int i = 0; i < a; i++){
            res += Math.pow(10,i);
        }
        for(int i = 0; i < b; i++){
            res += Math.pow(10,i);
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
