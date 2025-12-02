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

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            if(s.equals("yonsei")){
                bw.write("Yonsei Won!");
                break;
            } else if(s.equals("korea")){
                bw.write("Yonsei Lost...");
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
