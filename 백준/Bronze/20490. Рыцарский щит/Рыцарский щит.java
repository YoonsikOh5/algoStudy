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

        int[] arr1 = new int[3];
        int[] arr2 = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr1[0] = Integer.parseInt(st.nextToken());
        arr1[1] = Integer.parseInt(st.nextToken());
        arr1[2] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr2[0] = Integer.parseInt(st.nextToken());
        arr2[1] = Integer.parseInt(st.nextToken());
        arr2[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = arr2[2] - arr1[2];
        int cur = Math.abs(i);

        int res = arr1[0] + arr1[1] + arr2[0] + arr2[1] + cur;

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
