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

        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int np = n+p;
        int[] arr = new int[np];
        for(int i = 1; i < n; i++){
            int cur = Integer.parseInt(st.nextToken());
            arr[cur] = 1;
        }

        for(int i = p; i < np; i++){
            if(arr[i] == 0){
                bw.write(i+"");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
