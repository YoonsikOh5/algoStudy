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
        int len = N * 10;
        int[] arr = new int[51];
        for(int i = 0; i < len; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                int cur = Integer.parseInt(st.nextToken());
                arr[cur]++;
            }
        }
        boolean isT = true;
        for(int i = 1; i <= 50; i++){
            if(arr[i]>2*N){
                bw.write(i+" ");
                isT = false;
            }
        }

        if(isT){
            bw.write("-1");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
