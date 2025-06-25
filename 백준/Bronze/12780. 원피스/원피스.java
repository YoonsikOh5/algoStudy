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

        // 12780 원피스

        String s = br.readLine();

        int ls = s.length();

        String target = br.readLine();

        int lt = target.length();

        int lim = ls - lt;
        int cnt = 0;
        for(int i = 0; i <= lim; i++){
            if(s.charAt(i)==target.charAt(0)){
                boolean isT = true;
                for(int j = 0; j < lt; j++){
                    if(s.charAt(i+j) != target.charAt(j)){
                        isT = false;
                    }
                }
                if(isT){
                    cnt++;
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
