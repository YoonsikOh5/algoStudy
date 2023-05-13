import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        for (int i = 0; i < 6; i++) {
            int a = Integer.parseInt(st.nextToken());
            result += a;
        }


        bw.write((result * 5) + "");
        bw.flush();
        bw.close();
        br.close();
    }


}
