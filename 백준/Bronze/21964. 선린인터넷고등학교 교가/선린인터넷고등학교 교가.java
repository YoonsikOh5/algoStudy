import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        String substring = str.substring(N - 5, N);

        bw.write(substring);
        bw.flush();
        bw.close();
        br.close();
    }


}