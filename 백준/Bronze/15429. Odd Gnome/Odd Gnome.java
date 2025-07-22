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

            StringTokenizer st = new StringTokenizer(br.readLine());

            int g = Integer.parseInt(st.nextToken());

            int bef = Integer.parseInt(st.nextToken());
            for(int j = 1; j < g; j++){
                int cur = Integer.parseInt(st.nextToken());
                if(cur != bef+1){
                    bw.write((j+1)+"");
                    break;
                } else {
                    bef = cur;
                }
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
