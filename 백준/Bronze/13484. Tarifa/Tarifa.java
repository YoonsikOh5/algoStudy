import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(br.readLine());
            sum += (X-cur);
        }

        bw.write((sum+X)+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
