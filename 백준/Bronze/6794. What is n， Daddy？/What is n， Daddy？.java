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

        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 2;
        arr[4] = 3;
        arr[5] = 3;
        arr[6] = 3;
        arr[7] = 2;
        arr[8] = 2;
        arr[9] = 1;
        arr[10] = 1;

        bw.write(arr[N]+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
