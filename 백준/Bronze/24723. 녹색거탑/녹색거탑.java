import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = 1;

        for(int i = 1; i <= n; i++){
            result *= 2;
        }

        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();
    }

}