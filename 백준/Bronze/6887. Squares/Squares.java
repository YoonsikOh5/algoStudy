import java.io.*;
import java.util.*;

public class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        double sqrt = Math.sqrt(a);
        int result = (int) sqrt;
        bw.write("The largest square has side length "+result+".");
        bw.flush();
        bw.close();
        br.close();
    }


}