import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int A = T / 300;
        T = T % 300;
        int B = T / 60;
        T = T % 60;
        int C = T / 10;
        T = T % 10;

        if(T > 0){
            bw.write("-1");
        } else {
            bw.write(A+" "+B+" "+C);
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
