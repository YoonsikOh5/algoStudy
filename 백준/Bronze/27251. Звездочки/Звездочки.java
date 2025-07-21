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

        for(int i = 1; i <= N; i++){
            int cur = i * i;
            boolean ish = false;
            if(cur > 100){
                cur = 100;
                ish = true;
            }
            for(int j = 0; j < cur; j++){
                bw.write("*");
            }
            if(ish){
                bw.write("...");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
