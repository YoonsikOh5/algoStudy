import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int min = Integer.MAX_VALUE;

            for(int j = 0; j < N; j++){
                int s = Integer.parseInt(st.nextToken());
                if(s != -1){
                    min = Math.min(min, s);
                }
            }
            int remain = 0;
            if(min == Integer.MAX_VALUE){
                remain = L;
            } else {
                int sl = M - min;
                remain = Math.max(sl, L);
            }

            if(remain == 1){
                bw.write("The scoreboard has been frozen with "+remain+" minute remaining.\n");
            } else {
                bw.write("The scoreboard has been frozen with "+remain+" minutes remaining.\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
