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
        int[] arr = new int[5];

        for(int i = 0; i < 10; i++){
            int cur = Integer.parseInt(st.nextToken());
            arr[cur] = 1;
        }
        int cnt = 0;
        for(int i = 1; i <= 4; i++){
            if(arr[i]==0){
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
