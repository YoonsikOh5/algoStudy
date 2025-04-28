import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        int[] sarr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            sarr[j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 1; i <= D; i++) {
            for (int j = 1; j <= N; j++) {
                arr[j] += sarr[j];
                if (arr[j] > K) {
                    arr = new int[N + 1];
                    cnt += 1;
                    i--;
                    break;
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
