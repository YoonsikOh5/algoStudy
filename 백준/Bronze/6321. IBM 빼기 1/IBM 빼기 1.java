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

        for(int i = 1; i <= N; i++){
            String cur = br.readLine();
            int len = cur.length();


            bw.write("String #"+i+"\n");
            for(int j = 0; j < len; j++){
                char c = cur.charAt(j);
                int ci = c - 'A';
                char c1 = (char) ((ci + 1)%26 + 'A');
                bw.write(c1+"");
            }
            bw.write("\n\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
