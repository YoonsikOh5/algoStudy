import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int i = N / 2;
        int j = M / 2;

        if (i < j) {
            bw.write(i + "");
        } else {
            bw.write( j +"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}