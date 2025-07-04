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

        String s = br.readLine();
        int len = s.length();

        int cnt = 0;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c=='O'){
                cnt++;
            }
        }
        int hlf = N / 2;
        if(N % 2 == 1){
            hlf++;
        }

        if(cnt >= hlf){
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
