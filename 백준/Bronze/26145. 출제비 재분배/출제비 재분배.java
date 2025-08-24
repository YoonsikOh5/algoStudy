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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int c = Integer.parseInt(st.nextToken());
            arr[i] = c;
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < (N+M); j++){
                int cur = Integer.parseInt(st.nextToken());
                arr[i] -= cur;
                arr[j] += cur;
            }
        }

        for(int i = 0; i < (N+M); i++){
            bw.write(arr[i]+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
