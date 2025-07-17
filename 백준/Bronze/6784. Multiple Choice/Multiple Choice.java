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
        String[] arr = new String[N];
        int res = 0;
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }

        for(int i = 0; i < N; i++){
            if(br.readLine().equals(arr[i])){
                res++;
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
