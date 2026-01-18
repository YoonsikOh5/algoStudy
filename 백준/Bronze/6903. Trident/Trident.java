import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        int h = Integer.parseInt(br.readLine());

        for(int i = 1; i <= t; i++){
            bw.write("*");
            for(int j = 1; j <= s; j++){
                bw.write(" ");
            }
            bw.write("*");
            for(int j = 1; j <= s; j++){
                bw.write(" ");
            }
            bw.write("*");
            bw.write("\n");
        }
        int k = (s * 2) + 3;
        for(int i = 1; i <= k; i++){
            bw.write("*");
        }
        bw.write("\n");
        for(int i = 1; i <= h; i++){
            int a = s + 1;
            for(int j = 1; j <= a; j++){
                bw.write(" ");
            }
            bw.write("*\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
