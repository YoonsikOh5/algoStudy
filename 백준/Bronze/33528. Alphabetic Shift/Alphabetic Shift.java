import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < len; j++){
                char cur = s.charAt(j);
                int ci = (cur - 'A' + 26 - i) % 26;
                char shift = (char) (ci + 'A');
                bw.write(shift+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
