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
        int R = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i = 0; i < R; i++){
            int cur = Integer.parseInt(st.nextToken());
            arr[cur] = 1;
        }

        boolean isT = true;
        for(int i = 1; i <= N; i++){
            if(arr[i]==0) {
                isT = false;
                bw.write(i+" ");
            }
        }
        if(isT){
            bw.write("*");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
