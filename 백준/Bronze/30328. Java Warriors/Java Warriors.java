import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cur = Integer.parseInt(br.readLine());
        int result = cur*4000;

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

}