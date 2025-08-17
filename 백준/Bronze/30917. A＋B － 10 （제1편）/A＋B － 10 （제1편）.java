import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        for (int i = 1; i <= 9; i++) {
            System.out.println("? A " + i);

            int cur = sc.nextInt();
            if(cur==1){
                a = i;
                break;
            }
        }

        for (int i = 1; i <= 9; i++) {
            System.out.println("? B " + i);

            int cur = sc.nextInt();
            if(cur==1){
                b = i;
                break;
            }
        }

        System.out.println("! " + (a + b));
//        bw.flush();
//        bw.close();
//        br.close();
    }

}
