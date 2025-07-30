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

        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            for(int j = 2; j < N; j++){
                int bef = arr[j - 1];
                int aft = arr[j + 1];
                if(arr[j] > bef && arr[j] > aft){
                    cnt++;
                }
            }
            bw.write("Case #"+i+": "+cnt+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
