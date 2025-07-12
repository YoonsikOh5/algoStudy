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

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int cd2 = c / 2;

            if(cd2 <= b){
                int rem = c % 2;
                if(a >= rem){
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            } else {
                int rem = c - b*2;
                if(a >= rem){
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

}
