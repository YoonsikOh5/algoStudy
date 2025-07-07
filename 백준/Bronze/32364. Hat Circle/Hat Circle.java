import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(N % 2 == 1){
            bw.write("0");
        } else {
            int hlf = N / 2;
            int cnt = 0;
            for(int i = 1; i <= hlf; i++){
                if(arr[i]==arr[hlf+i]){
                    cnt += 2;
                }
            }
            bw.write(cnt+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
