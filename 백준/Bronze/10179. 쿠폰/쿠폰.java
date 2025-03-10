import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            double cur = Double.parseDouble(br.readLine());
            double res = cur * 0.8;
            bw.write("$"+String.format("%.2f",res)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
