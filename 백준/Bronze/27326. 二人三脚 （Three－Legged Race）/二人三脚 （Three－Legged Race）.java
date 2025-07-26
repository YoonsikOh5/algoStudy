import java.io.*;
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
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i < 2*N; i++){
            int cur = Integer.parseInt(st.nextToken());
            arr[cur]++;
        }
        
        for(int i = 1; i <= N; i++){
            if(arr[i]==1){
                bw.write(i+"");
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
