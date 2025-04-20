import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(cur < min){
                min = cur;
                idx = i;
            }
        }
        bw.write(idx+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
