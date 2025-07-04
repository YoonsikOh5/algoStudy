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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean ytturn = true;
        while (true){
            if(ytturn){
                b += a;
                if(b >= 5){
                    bw.write("yt");
                    break;
                }
                ytturn = false;
            } else {
                a += b;
                if(a >= 5){
                    bw.write("yj");
                    break;
                }
                ytturn = true;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
