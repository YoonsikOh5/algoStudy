import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        Integer integer = (int) ((a + 1) * (b + 1) / (c + 1) - 1);

        bw.write(integer + "");
        bw.flush();
        bw.close();
        br.close();
    }


}
