import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());

        boolean samp = true;
        boolean sys = true;

        for(int i = 1; i <= S1; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if(a!=b){
                samp = false;
            }
        }

        for(int i = 1; i <= S2; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if(a!=b){
                sys = false;
            }
        }

        if(samp&&sys){
            bw.write("Accepted");
        } else if(!samp){
            bw.write("Wrong Answer");
        } else {
            bw.write("Why Wrong!!!");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
