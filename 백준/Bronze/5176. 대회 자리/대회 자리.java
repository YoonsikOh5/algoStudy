import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[M+1];
            int cnt = 0;
            for (int j = 0; j < P; j++) {
                int cur = Integer.parseInt(br.readLine());
                if(arr[cur] == 1){
                    cnt++;
                }
                arr[cur] = 1;
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
