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
        StringTokenizer st = new StringTokenizer(br.readLine());;
        int even = 0;
        int odd = 0;
        for(int i = 0; i < N; i++){
            if(Integer.parseInt(st.nextToken())%2 == 0){
                even++;
            } else {
                odd++;
            }
        }

        if(even > odd){
            bw.write("2 0");
        } else {
            bw.write("2 1");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
