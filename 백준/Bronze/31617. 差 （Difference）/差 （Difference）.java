import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] arrA = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrB = new int[M+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= M; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if((arrA[i] + K) == arrB[j]){
                    res++;
                }
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
