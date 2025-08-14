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

        int[] arr = new int[5];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 0 || b == 0){
                arr[0]++;
            } else if(a > 0 && b > 0){
                arr[1]++;
            } else if(a < 0 && b > 0){
                arr[2]++;
            } else if(a < 0 && b < 0){
                arr[3]++;
            } else if(a > 0 && b < 0){
                arr[4]++;
            }
        }
        for(int i = 1; i <= 4; i++){
            bw.write("Q"+i+": "+arr[i]+"\n");
        }
        bw.write("AXIS: "+arr[0]);
        bw.flush();
        bw.close();
        br.close();
    }

}
