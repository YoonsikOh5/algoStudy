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

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isT = true;
        for(int i = 1; i <= N; i++){
            String s = st.nextToken();

            if(s.equals("mumble")){
                continue;
            } else {
                int cur = Integer.parseInt(s);
                if(cur != i){
                    isT = false;
                    break;
                }
            }
        }

        if(isT){
            bw.write("makes sense");
        } else{
            bw.write("something is fishy");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
