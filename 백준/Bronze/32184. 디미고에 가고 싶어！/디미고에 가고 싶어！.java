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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean read = false;
        int cnt = 0;
        if(A % 2 == 0){
            cnt++;
            A+=1;
        }
        if(B % 2 == 1){
            cnt++;
            B-=1;
        }
        int i = B - A + 1;
        int i1 = i / 2;
        cnt += i1;
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
