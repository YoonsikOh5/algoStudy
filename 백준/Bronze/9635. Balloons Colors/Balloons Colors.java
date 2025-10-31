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

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            boolean isE = false;
            boolean isH = false;

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int cur = Integer.parseInt(st.nextToken());
                if(j == 1){
                    if(cur == X){
                        isE = true;
                    }
                }
                if(j == N){
                    if(cur == Y){
                        isH = true;
                    }
                }
            }

            if(isE && isH){
                bw.write("BOTH\n");
            } else if(isE && !isH){
                bw.write("EASY\n");
            } else if(!isE && isH){
                bw.write("HARD\n");
            } else if(!isE && !isH){
                bw.write("OKAY\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
