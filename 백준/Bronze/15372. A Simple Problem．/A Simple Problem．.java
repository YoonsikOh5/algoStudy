import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            long a = Long.parseLong(br.readLine());
            bw.write(a*a+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}