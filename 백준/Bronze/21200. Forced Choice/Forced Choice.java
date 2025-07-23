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

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= S; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            boolean isT = true;
            for(int j = 0; j < m; j++){
                if(Integer.parseInt(st.nextToken())==P){
                    isT = false;
                    break;
                }
            }

            if(!isT){
                bw.write("KEEP");
            } else {
                bw.write("REMOVE");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
