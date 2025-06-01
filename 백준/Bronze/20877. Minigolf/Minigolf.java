import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur >= 7){
                cur = 7;
            }
            if(i % 2 == 0){
                sum -= 3;
            } else if(i % 2 == 1){
                sum -= 2;
            }
            sum += cur;
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
