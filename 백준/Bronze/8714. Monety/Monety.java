import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt1 = 0;
        int cnt0 = 0;
        for(int i = 0; i  < N; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(cur == 0){
                cnt0++;
            } else if(cur == 1){
                cnt1++;
            }
        }
        int res = Math.min(cnt1, cnt0);
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
