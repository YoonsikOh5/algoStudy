import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        while (!(B==0 && N==0)){
            int minA = 0;
            int minabs = Integer.MAX_VALUE;
            for(int A = 1; A <= 1000000; A++){
                int cur = 1;
                for(int i = 0; i < N; i++){
                    cur *= A;
                }
                if(cur > B){
                    int abs = Math.abs((cur - B));
                    if(abs < minabs){
                        minabs = abs;
                        minA = A;
                    }
                    break;
                } else {
                    int abs = Math.abs((cur - B));
                    if(abs < minabs){
                        minabs = abs;
                        minA = A;
                    }
                }
            }

            bw.write(minA+"\n");
            st = new StringTokenizer(br.readLine());
            B = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
