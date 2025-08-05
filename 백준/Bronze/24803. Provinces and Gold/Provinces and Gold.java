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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int total = g*3 + s*2 + c;

        String vp = "";
        String tr = "";

        if(total >= 8){
            vp = "Province";
        } else if(total >= 5){
            vp = "Duchy";
        } else if(total >= 2){
            vp = "Estate";
        }

        if(total >= 6){
            tr = "Gold";
        } else if(total >= 3){
            tr = "Silver";
        } else {
            tr = "Copper";
        }

        if(!vp.equals("")){
            bw.write(vp+" or "+tr);
        } else {
            bw.write(tr+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
