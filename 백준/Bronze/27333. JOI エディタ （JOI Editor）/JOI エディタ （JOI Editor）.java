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

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N-1; i++){
            char cur = s.charAt(i);
            if(cur == s.charAt(i+1)){
                char c = Character.toUpperCase(cur);
                sb.append(c);
                sb.append(c);
                i++;
            } else {
                sb.append(cur);
            }
        }
        String s1 = sb.toString();
        bw.write(s1+"");
        if(s1.length() != N){
            bw.write(s.charAt(N-1)+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
