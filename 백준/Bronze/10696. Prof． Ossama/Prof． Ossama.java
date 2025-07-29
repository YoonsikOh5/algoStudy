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

        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int cur = Integer.parseInt(st.nextToken());

            long rem = 0;
            for(int j = 0; j < str.length(); j++){
                int cs = str.charAt(j) - '0';
                rem = (rem*10 + cs) % cur;
            }
            bw.write("Case "+i+": "+rem+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
