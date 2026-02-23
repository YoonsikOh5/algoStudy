import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String cur = "SciComLove";
        int mod = N % 10;

        String res = cur.substring(mod);
        bw.write(res+"");
        for(int i = 0; i < mod; i++){
            bw.write(cur.charAt(i)+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
