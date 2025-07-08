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

        String s = br.readLine();

        boolean isStrong = false;
        boolean lastns = false;

        char lc = s.charAt(s.length() - 1);
        if(lc=='n' || lc=='s' || lc=='a' || lc=='e' || lc=='i' || lc=='o' || lc=='u'){
            lastns = true;
        }

        int lastidx = -1;
        int secidx = -1;

        int len = s.length();

        for(int i = 0; i < len; i++){
            char cur = s.charAt(i);
            if(cur == 'á' || cur == 'é' || cur == 'í' || cur == 'ó' || cur == 'ú'){
                isStrong = true;
                bw.write(i+1+"");
                break;
            }
            if(cur=='a' || cur=='e' || cur=='i' || cur=='o' || cur=='u'){
                secidx = lastidx;
                lastidx = i+1;
            }
        }

        if(!isStrong){
            if(!lastns){
                bw.write((lastidx)+"");
            } else {
                bw.write((secidx)+"");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
