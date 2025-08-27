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

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int cur = Integer.parseInt(st.nextToken());
            sum += cur;
            arr[i] = cur;
        }

        for(int i = 1; i <= N; i++){
            int cur = arr[i];
            if((sum-cur)==cur){
                bw.write(i+"");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
