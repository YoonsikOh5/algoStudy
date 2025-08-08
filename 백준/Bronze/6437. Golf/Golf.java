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
        int tc = 0;
        while (true){
            tc++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==0 && b==0){
                break;
            }
            int dif = a - b;
            String res = "";
            if(b==1){
                res = "Hole-in-one.";
            } else if(dif == 0){
                res = "Par.";
            } else if(dif == 1){
                res = "Birdie.";
            } else if(dif == 2){
                res = "Eagle.";
            } else if(dif == 3){
                res = "Double eagle.";
            } else if(dif == -1){
                res = "Bogey.";
            } else if(dif == -2){
                res = "Double Bogey.";
            }else if(dif < -2){
                res = "Double Bogey.";
            }
            bw.write("Hole #"+tc+"\n"+res+"\n\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
