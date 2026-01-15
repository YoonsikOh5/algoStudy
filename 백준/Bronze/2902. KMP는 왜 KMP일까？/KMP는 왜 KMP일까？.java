import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] sp = s.split("-");
        int len = sp.length;
        for(int i = 0; i < len; i++){
            String s1 = sp[i];
            char c = s1.charAt(0);
            bw.write(c+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
