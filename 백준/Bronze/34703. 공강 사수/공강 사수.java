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

        int X = Integer.parseInt(br.readLine());

        int[] arr = new int[6];

        for (int i = 1; i <= X; i++) {
            int cur = Integer.parseInt(br.readLine());
            arr[cur] = 1;
        }
        boolean isT = false;
        for (int i = 1; i <= 5; i++) {
            if (arr[i] == 0) {
                isT = true;
            }
        }

        if (isT) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
