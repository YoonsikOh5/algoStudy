import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int len = s.length();

        int u = s.indexOf('U');
        int f = s.lastIndexOf('F');

        for(int i = 0 ; i < u; i++){
            bw.write("-");
        }
        bw.write("U");
        int len2 = f - u;
        for(int i = 1; i < len2; i++){
            bw.write("C");
        }
        bw.write("F");
        int len3 = len - f;
        for(int i = 1; i < len3; i++){
            bw.write("-");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
