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

        for (int x = -1000; x <= 1000; x++) {
            int res = (x * x) + (2 * a * x) + b;
            if(res == 0){
                bw.write(x+" ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
